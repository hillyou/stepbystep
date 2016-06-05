/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

/**
 *
 * @author yougu
 */
public class ExceptionThrower {

    static int a = 10;
    static Object o=null;

    public ExceptionThrower() {
    }

    public static void throwException() {
        if (a == 10) {
            throw new RuntimeException();
        }
    }

    public static void catchException() {
        try {
            if (a == 10) {
                throw new Exception("error");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("xxxxx",e);
        }
    }
    
    public static void nullException() {
        try {
            o.getClass();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("null o",e);
        }
    }
    
    public static void main(String[] args){
//        throwException();
        nullException();
    }
}
