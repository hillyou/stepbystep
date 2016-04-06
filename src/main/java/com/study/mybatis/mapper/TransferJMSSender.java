/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

import com.study.mybatis.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Colin.You
 */
@Repository
public class TransferJMSSender {

    @Autowired(required = false)
    private JmsTemplate transferSender;

    public void transfer(final Account account) {
        transferSender.convertAndSend(account);
        throw new RuntimeException("Mocked exception throwed out.");
    }
}
