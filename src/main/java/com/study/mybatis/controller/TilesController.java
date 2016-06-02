/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Colin_You
 */
@Controller
public class TilesController {

    @RequestMapping(value = "/body1", method = RequestMethod.GET)
    public String body1() {
        return "body1";
    }

}
