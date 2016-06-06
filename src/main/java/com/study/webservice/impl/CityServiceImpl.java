/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.webservice.impl;

import com.study.cxf.common.ServiceException;
import com.study.mybatis.mapper.CityMapper;
import com.study.mybatis.model.City;
import com.study.mybatis.model.Response;
import com.study.webservice.CityService;
import com.study.webservice.Person;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Colin.You
 */
@WebService(endpointInterface = "com.study.webservice.CityService")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Response getCities() throws ServiceException {
        try{
        Response response = new Response();
        List<City> cities = cityMapper.getAll();
        response.setResult(cities);
        return response;
        }catch(Exception e){
            throw new ServiceException("service error",null,e);
        }
    }

    @Override
    public Response getCity(int cityId) {
        Response response = new Response();
        City city = cityMapper.getById(cityId);
        if (city == null) {
            response.setHasError(true);
            response.setMessage("No City could be found with id " + cityId);
        } else {
            List cities=new ArrayList<>();
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
    public Person testResponse(){
        Person p=new Person();
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
