/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.service;

import com.study.mybatis.model.City;
import com.study.mybatis.model.Response;
import com.study.webservice.CityService;
import javax.annotation.Resource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Colin_You
 */
@Service
@Primary
public class WSHandler implements Handler {

//    @Resource(name = "cityClientRSName")
    @Resource(name = "cityClientWS1Name")
    private CityService cityService;

    @Override
    public Response getAll() {
        return cityService.getCities();
    }

    @Override
    public Response getById(int id) {
        return cityService.getCity(id);
    }

    @Override
    public int create(City city) {
        return cityService.create(city);
    }

    @Override
    public void update(City city) {
        cityService.update(city);
    }

    @Override
    public void delete(int id) {
        cityService.delete(id);
    }
}
