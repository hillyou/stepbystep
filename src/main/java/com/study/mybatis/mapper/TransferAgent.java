/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

import org.springframework.stereotype.Service;

/**
 *
 * @author Colin.You
 */
@Service("transferMessageListener")
public class TransferAgent //implements MessageListener
{

//    @Autowired
//    @Qualifier("accountMapperJunit")
//    private AccountMapper accountMapper;
//
//    private int count = 0;
//
//    @Override
//    public void onMessage(Message msg) {
//        if (msg instanceof ObjectMessage) {
//            try {
//                ObjectMessage message = (ObjectMessage) msg;
//                Account account = (Account) message.getObject();
//                accountMapper.transfer(account);
//                if (count == 0) {
//                    count++;
//                    throw new RuntimeException("First time failed, then transaction will roll back.");
//                }
//                count = 0;
//            } catch (TransferException | JMSException ex) {
//                Logger.getLogger(TransferAgent.class.getName()).log(Level.SEVERE, null, ex);
//                throw new RuntimeException(ex);
//            }
//        }
//        System.out.println(msg);
//    }
}
