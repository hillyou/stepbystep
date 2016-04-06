/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

import com.study.mybatis.dao.AccountDAO;
import com.study.mybatis.model.Account;
import java.text.DecimalFormat;
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
@Service
public class JTAMapper {

    @Autowired
    @Qualifier("accountDAO")
    private AccountDAO accountDAO;

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public boolean transfer(int sid, int did, float changeAmount) throws TransferException {
        if (changeAmount < 0) {
            throw new TransferException("Transfer error, transfer amount must be greater than zero.");
        }
        Account currentOut = accountDAO.getAccountForUpdate(sid);
        if (currentOut == null) {
            throw new TransferException("Transfer failed, source account did not exist.");
        } else if (currentOut.getMoney() < changeAmount) {
            throw new TransferException("Transfer failed, insufficient balance.");
        }
        currentOut.setMoney(round(currentOut.getMoney() - changeAmount));
        accountDAO.transfer(currentOut);
        return true;
    }

    private static float round(float beforeRound) {
        DecimalFormat df = new DecimalFormat("###.##");
        return Float.parseFloat(df.format(beforeRound));
    }

    public static void main(String[] args) {
        System.out.println(round(99.991f));
        System.out.println(round(100.048f));
        System.out.println(round(11.236f));
        System.out.println(round(15.260f));
    }

}
