/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.webservice.impl;

import com.study.cxf.common.FaultBean;
import com.study.cxf.common.ServiceException;
import com.study.mybatis.mapper.CityMapper;
import com.study.mybatis.model.City;
import com.study.mybatis.model.Response;
import com.study.webservice.CityService;
import com.study.webservice.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.jws.WebService;
import org.apache.cxf.common.i18n.Message;
import org.apache.cxf.interceptor.Fault;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.util.Assert;

/**
 *
 * @author Colin.You
 */
@WebService(endpointInterface = "com.study.webservice.CityService")
public class CityServiceImpl implements CityService {

    private static final Logger LOOGER = Logger.getLogger(CityServiceImpl.class);
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private MessageSource messageSource;

    @PostConstruct
    private void inital() {
        Assert.notNull(cityMapper, "city mapper not initalized");
        Assert.notNull(messageSource, "message source not initalized");
    }

    @Override
    public Response getCities() throws ServiceException {
        try {
            Response response = new Response();
            List<City> cities = cityMapper.getAll();
            response.setResult(cities);
            return response;
        } catch (Exception e) {
            LOOGER.error("Get all city entity error", e);
            throw new ServiceException("500", new FaultBean(500, "service internal error"));
        }
    }

    @Override
    public Response getCity(int cityId) {
        Response response = new Response();
        City city = cityMapper.getById(cityId);
        if (city == null) {
            response.setHasError(true);
            response.setMessage("No City could be found with id " + cityId);
            throw new Fault(new Message("error.not.found", new MessageSourceResourceBundle(messageSource, Locale.SIMPLIFIED_CHINESE), cityId));
//            throw new Fault(new Throwable("No city could be found with id " + cityId));
        } else {
            List cities = new ArrayList<>();
            cities.add(city);
            response.setResult(cities);
        }
        return response;
    }

    @Override
    public int create(City city) {
        return cityMapper.create(city);
    }

    @Override
    public Person testResponse() {
        Person p = new Person();
        p.setName("Jack");
        return p;
    }

    @Override
    public void update(City city) {
        cityMapper.update(city);
    }

    @Override
    public void delete(int cityId) {
        City city = new City();
        city.setCityId(cityId);
        cityMapper.delete(city);
    }
}
