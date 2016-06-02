/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.controller;

import com.study.mybatis.model.City;
import com.study.mybatis.model.Response;
import com.study.mybatis.service.CityServiceHandler;
import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Colin.You
 */
@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityServiceHandler cityServiceHandler;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getCities() {
        ModelAndView mv = new ModelAndView("cities");
        Response response = cityServiceHandler.getAll();
        mv.addObject("cities", response.getResult());
        return mv;
    }

    @RequestMapping(value = "/all/jsonview/{id}", method = RequestMethod.GET)
    @JsonView(City.class)
    @ResponseBody
    public City getCitiesJsonView(@PathVariable("id") int id) {
        Response response = cityServiceHandler.getById(id);
        return response.getResult() != null ? response.getResult().get(0) : null;
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public ModelAndView getCity(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("cities");
        Response response = cityServiceHandler.getById(id);
        mv.addObject("city", response.getResult());
        mv.addObject("response", response);
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("city") City city, BindingResult result) {
        ModelAndView mv = new ModelAndView("message");
        int id = cityServiceHandler.create(city);
        mv.addObject("message", "City " + id + " has been created successfully ");
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ModelAndView update(@ModelAttribute City city, BindingResult result) {
        ModelAndView mv = new ModelAndView("message");
        cityServiceHandler.update(city);
        mv.addObject("message", "Update City Successfully");
        return mv;
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("message");
        cityServiceHandler.delete(id);
        mv.addObject("message", "Delete City Successfully");
        return mv;
    }

//    @ModelAttribute
//    public City bindCity(@RequestParam("LANGUAGE") String language,
//            @RequestParam("AIRPORT") String airport,
//            @RequestParam("COUNTRY") String country,
//            @RequestParam("CITY_NAME") String cityName
//    ) {
//        City city = new City();
//        city.setAirport(airport);
//        city.setCityName(cityName);
//        city.setCountry(country);
//        city.setLanguage(language);
//        return city;
//    }
}
