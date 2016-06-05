/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.model;

import java.io.Serializable;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Colin.You
 */
@XmlRootElement(name = "Account")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account")
public class Account implements Serializable {

    private static final long serialVersionUID = 7677246925935518538L;

    @FormParam("accountId")
    private int account_id;
    @FormParam("money")
    private float money;
    @FormParam("changeAmount")
    private float changeAmount;
    private Boolean transferIn = false;
    private Boolean transferOut = false;

    public Account() {

    }

    public Account(float money, int account_id) {
        this.money = money;
        this.account_id = account_id;
    }

    public Account(int account_id, float changeAmount) {
        this.account_id = account_id;
        this.changeAmount = changeAmount;
    }

    public static Account createInInstance(int account_id, float changeAmount) {
        Account a = new Account(account_id, changeAmount);
        a.setTransferIn(true);
        return a;
    }

    public static Account createOutInstance(int account_id, float changeAmount) {
        Account a = new Account(account_id, changeAmount);
        a.setTransferOut(true);
        return a;
    }

    public Boolean getTransferIn() {
        return transferIn;
    }

    public void setTransferIn(Boolean transferIn) {
        this.transferIn = transferIn;
    }

    public Boolean getTransferOut() {
        return transferOut;
    }

    public void setTransferOut(Boolean transferOut) {
        this.transferOut = transferOut;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(float changeAmount) {
        this.changeAmount = changeAmount;
    }

}
