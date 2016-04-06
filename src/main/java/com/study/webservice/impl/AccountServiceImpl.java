/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.webservice.impl;

import com.study.mybatis.mapper.AccountMapper;
import com.study.mybatis.mapper.JTAMapper;
import com.study.mybatis.mapper.TransferException;
import com.study.mybatis.model.Account;
import com.study.mybatis.model.Response;
import com.study.webservice.AccountService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Colin.You
 */
@WebService(endpointInterface = "com.study.webservice.AccountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountMapper")
    private AccountMapper accountMapper;

    @Autowired
    private JTAMapper jtaMapper;

    @Override
    public Account getAccount(int accountId) {
        Account account = accountMapper.getAccount(accountId);
        return account;
    }

    @Override
    public void create(Account account) {
        accountMapper.insert(account);
    }

    @Override
    public void update(Account account) {
        accountMapper.update(account);
    }

    @Override
    public Response transfer(Account account) {
        Response resp = new Response();
        try {
            accountMapper.transfer(account);
        } catch (TransferException ex) {
            resp.setHasError(true);
            resp.setMessage(ex.getMessage());
            Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public Response transfer(int sourceId, float money, String action) {
        Response resp = new Response();
        Account account = null;
        if ("IN".equalsIgnoreCase(action)) {
            account = Account.createInInstance(sourceId, money);
        } else if ("OUT".equalsIgnoreCase(action)) {
            account = Account.createOutInstance(sourceId, money);
        } else {
            resp.setHasError(true);
            resp.setMessage("Transfer failed, transferation operation '" + action + "' error");
        }
        resp = transfer(account);
        return resp;
    }

    @Override
    public Response transferByJMS(int sourceId, int destId, float money) {
        Response resp = new Response();
        try {
            Account sAccount = Account.createOutInstance(sourceId, money);
            Account dAccount = Account.createInInstance(destId, money);
            accountMapper.transfer(sAccount, dAccount);
        } catch (TransferException ex) {
            resp.setHasError(true);
            resp.setMessage(ex.getMessage());
            Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    @Override
    public Response transferWithJTA(int sourceId, int destId, float money) {
        Response resp = new Response();
        try {
            boolean flag = jtaMapper.transfer(sourceId, destId, money);
            resp.setHasError(!flag);
        } catch (TransferException ex) {
            resp.setHasError(true);
            resp.setMessage(ex.getMessage());
            Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
