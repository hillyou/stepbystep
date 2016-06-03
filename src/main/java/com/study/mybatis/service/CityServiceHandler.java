/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.service;

import com.study.mybatis.model.City;
import com.study.mybatis.model.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Colin.You
 */
@Service
public class CityServiceHandler implements Handler {

    @Autowired(required = false)
    private WebClient webClient;

    public Response getAll() {
        webClient.reset();
        Response response = webClient.path("/rs/cities/all").accept(MediaType.APPLICATION_JSON).get(Response.class);
        return response;
    }

    public Response getById(int id) {
        webClient.reset();
        Response response = webClient.path("/rs/cities/all/" + id).accept(MediaType.APPLICATION_JSON).get(Response.class);
        return response;
    }

    public int create(City city) {
        webClient.reset();
        int id = webClient.path("/rs/cities/create").accept(MediaType.APPLICATION_JSON).post(city, Integer.class);
        return id;
    }

    public void update(City city) {
        webClient.reset();
        webClient.path("/rs/cities/update").put(city);
    }

    public void delete(int id) {
        webClient.reset();
        webClient.path("/rs/cities/all/" + id).delete();
    }

}
