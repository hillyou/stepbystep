/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

import com.study.mybatis.dao.AccountDAO;
import com.study.mybatis.model.Account;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Colin.You
 */
@Service("accountMapper")
public class AccountMapper {

    private static final Logger LOG = Logger.getLogger(AccountMapper.class);
    @Autowired
    @Qualifier("accountDAO")
    private AccountDAO accountDAO;

    @Autowired(required = false)
    private TransferJMSSender jmsSender;

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    public Account getAccount(int accountId) {
        return accountDAO.getAccount(accountId);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void update(Account account) {
        accountDAO.update(account);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void insert(Account account) {
        accountDAO.insert(account);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    public int amountAccount(int money) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("money", money);
        accountDAO.amountAccount(params);
        return params.get("total");
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void transfer(Account account) throws TransferException {
        if (account == null || account.getAccount_id() < 0) {
            throw new TransferException("Transfer error, account error.");
        } else if (account.getChangeAmount() < 0) {
            throw new TransferException("Transfer error, transfer amount must be greater than zero.");
        }
        Account destAccount = accountDAO.getAccountForUpdate(account.getAccount_id());
        if (destAccount == null) {
            throw new TransferException("Transfer failed, the destination account did not exist.");
        }
        boolean transferIn = account.getTransferIn();
        boolean transferOut = account.getTransferOut();
        if (transferIn) {
            destAccount.setMoney(round(destAccount.getMoney() + account.getChangeAmount()));
        } else if (transferOut) {
            if (destAccount.getMoney() < account.getChangeAmount()) {
                throw new TransferException("Transfer failed, insufficient balance.");
            }
            destAccount.setMoney(round(destAccount.getMoney() - account.getChangeAmount()));
        } else {
            throw new TransferException("Transfer failed, no transfermation operation specified");
        }
        accountDAO.transfer(destAccount);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void transfer(Account sourceAccount, Account destAccount) throws TransferException {
        transfer(sourceAccount);
        transferByJMS(destAccount);
    }

    private void transferByJMS(Account account) throws TransferException {
        jmsSender.transfer(account);
//        throw new TransferException("Transfer failed, transfer by JMS error.");
    }

    private static float round(float beforeRound) {
        DecimalFormat df = new DecimalFormat("###.##");
        return Float.parseFloat(df.format(beforeRound));
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

}
