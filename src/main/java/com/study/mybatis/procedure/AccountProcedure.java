/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.procedure;

import com.study.mybatis.model.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Colin.You
 */
public class AccountProcedure {

    public static void totalAccount(int money, int[] total) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:testdb;create=true;")) {
            String sqlQuery = "SELECT COUNT(ACCOUNT_ID) FROM ACCOUNT WHERE MONEY < ?";
            if (money <= 0) {
                sqlQuery = "SELECT COUNT(ACCOUNT_ID) FROM ACCOUNT";
            }
            PreparedStatement p = conn.prepareStatement(sqlQuery);
            if (money > 0) {
                p.setInt(1, money);
            }
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                total[0] = rs.getInt(1);
            }
            rs.close();
            p.close();
        }
    }

    public static void allAccount(int money, Account[] results) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:testdb;create=false;")) {
            String sqlQuery = "SELECT * FROM ACCOUNT WHERE MONEY < ?";
            if (money <= 0) {
                sqlQuery = "SELECT * FROM ACCOUNT";
            }
            PreparedStatement p = conn.prepareStatement(sqlQuery);
            if (money > 0) {
                p.setInt(1, money);
            }
            ResultSet rs = p.executeQuery();
            List<Account> list;
            list = new ArrayList<Account>();
            if (rs.next()) {
                Account acount = new Account(rs.getInt(1), rs.getFloat(2));
                list.add(acount);
            }
            list.toArray(results);
            rs.close();
            p.close();
        }
    }
}
