/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.webservice;

import com.study.mybatis.model.Account;
import com.study.mybatis.model.Response;
import javax.jws.WebService;
import javax.ws.rs.BeanParam;
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
@Path("/account")
public interface AccountService {

    @GET
    @Path("/all/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Account getAccount(@PathParam("id") int accountId);

    @POST
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(@BeanParam Account account);

    @PUT
    @Path("/update")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void update(@BeanParam Account account);

    @PUT
    @Path("/transfer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response transfer(@BeanParam Account account);

    @PUT
    @Path("/transfer/single/{sid}-{money}-{inorout}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response transfer(@PathParam("sid") int sourceId, @PathParam("money") float money, @PathParam("inorout") String action);

    @PUT
    @Path("/transfer/{sid}-{did}-{money}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response transferByJMS(@PathParam("sid") int sourceId, @PathParam("did") int destId, @PathParam("money") float money);

    @PUT
    @Path("/transfer/jta/{sid}-{did}-{money}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response transferWithJTA(@PathParam("sid") int sourceId, @PathParam("did") int destId, @PathParam("money") float money);
}
