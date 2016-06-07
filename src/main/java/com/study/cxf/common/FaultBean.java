/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.cxf.common;

/**
 *
 * @author yougu
 */
public class FaultBean {

    private int code;
    private String details;

    public FaultBean() {

    }

    public FaultBean(int code, String details) {
        this.code = code;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
