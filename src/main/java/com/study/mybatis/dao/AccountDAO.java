/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.dao;

import com.study.mybatis.model.Account;
import java.util.Map;

/**
 *
 * @author Colin.You
 */
public interface AccountDAO {

    public Account getAccount(int id);

    public Account getAccountForUpdate(int id);

    public void transfer(Account account);

    public void update(Account account);

    public void insert(Account account);

    public void amountAccount(Map params);

    public void getAllAccount(Map params);
}
