/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.service;

import com.study.mybatis.model.City;
import com.study.mybatis.model.Response;

/**
 *
 * @author Colin_You
 */
public interface Handler {

    int create(City city);

    void delete(int id);

    Response getAll();

    Response getById(int id);

    void update(City city);

}
