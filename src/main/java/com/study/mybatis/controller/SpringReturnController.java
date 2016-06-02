/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Colin_You
 */
@Controller
@RequestMapping(value = "/return")
public class SpringReturnController {

    @RequestMapping(value = "/model")
    public Model getModel(Model model) {
        return model;
    }

    @RequestMapping(value = "/map")
    public Map getModel(Map map, Locale locale, TimeZone timeZone) {
        return map;
    }

    @RequestMapping(value = "/all")
    public ModelAndView getAll(ServletRequest request, HttpSession session,
            WebRequest webRequest, NativeWebRequest nativeWebRequest,
            //            InputStream inputStream, Reader reader,
            //            OutputStream outputStream, Writer writer,
            HttpMethod httpMethod, Principal principal,
            //            HttpEntity<?> entities, RedirectAttributes redirectAttributes,
            //            Errors errors, SessionStatus sessionStatus,
            //            UriComponentsBuilder uriComponentsBuilder,
            Model model, Locale locale, TimeZone timeZone) {
        ModelAndView m = new ModelAndView("return/model");
        m.addObject("Locale:", locale);
        m.addObject("TimeZone:", timeZone);
        return m;
    }
}
