/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.webservice;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Colin.You
 */
@XmlRootElement(name = "Person")
public class Person implements Serializable {

    @XmlElement
    private String name;

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

}
