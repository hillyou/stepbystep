/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

import com.study.mybatis.model.City;
import com.study.mybatis.util.DBSessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Colin.You
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context.xml"})
public class CityMapperTester {

    @Autowired
    private CityMapper cityMapper;

    public CityMapperTester() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        DBSessionFactory sessionFactory = new DBSessionFactory("dev");
//        cityMapper = new CityMapper();
//        cityMapper.setSessionFactory(sessionFactory);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetById() {
        City city1 = cityMapper.getById(129);
        assertNotNull(city1);
        assertEquals(129l, city1.getCityId().longValue());
        cityMapper.getById(129);
        cityMapper.getById(129);
    }

    @Test
    public void testCreate() {
        City city = new City();
        city.setAirport("OST");
        city.setCityName("Orlando");
        city.setCountry("US");
        city.setLanguage("Englsih");
        cityMapper.create(city);
    }
}
