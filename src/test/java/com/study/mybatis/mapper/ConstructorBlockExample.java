/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

/**
 *
 * @author Colin_You
 */
public class ConstructorBlockExample {

    {
        System.out.println("This is first constructor block");
    }

    public ConstructorBlockExample() {
        System.out.println("This is no parameter constructor");
    }

    public ConstructorBlockExample(String param1) {
        System.out.println("This is single parameter constructor");
    }

    public ConstructorBlockExample(String param1, String param2) {
        System.out.println("This is two parameters constructor");
    }

    {
        System.out.println("This is second constructor block");
    }

    public static void main(String[] args) {
        ConstructorBlockExample constrBlockEx
                = new ConstructorBlockExample();
        ConstructorBlockExample constrBlockEx1
                = new ConstructorBlockExample("param1");
        ConstructorBlockExample constrBlockEx2
                = new ConstructorBlockExample("param1", "param2");
    }
}
