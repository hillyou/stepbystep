/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.webservice;

import com.study.mybatis.model.City;
import com.study.mybatis.model.Response;
import javax.jws.WebService;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Colin.You
 */
@WebService
@Path("/cities")
public interface CityService {

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getCities();

    @GET
    @Path("/all/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCity(@PathParam("id") int cityId);

    @POST
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public int create(@BeanParam City city);

    @PUT
    @Path("/update")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void update(@BeanParam City city);

    @DELETE
    @Path("/all/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void delete(@PathParam("id") int cityId);

    @GET
    @Path("/test")
    @Produces({MediaType.APPLICATION_XML})
    public Person testResponse();
}
