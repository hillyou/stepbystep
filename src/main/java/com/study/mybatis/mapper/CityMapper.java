/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.mapper;

import com.study.mybatis.dao.CityDAO;
import java.util.List;
import com.study.mybatis.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Colin.You
 */
@Service
public class CityMapper {

//    @Resource(name = "sqlSession")
//    private SqlSession sqlSession;
    @Autowired
    private CityDAO cityDAO;

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    @CacheEvict(value = "cities", allEntries = true)
    public List<City> getAll() {
//        CityDAO cityDAO = sqlSession.getMapper(CityDAO.class);
        return cityDAO.getAll();
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
    @Cacheable(value = "cities", key = "#cityId")
    public City getById(int cityId) {
//        CityDAO cityDAO = sqlSession.getMapper(CityDAO.class);
        return cityDAO.getById(cityId);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @CacheEvict(value = "cities", allEntries = true)
    public int create(City city) {
//        CityDAO cityDAO = sqlSession.getMapper(CityDAO.class);
        cityDAO.create(city);
        int id = city.getCityId();
        return id;
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @CacheEvict(value = "cities", key = "#city.cityId")
    public void delete(City city) {
//        CityDAO cityDAO = sqlSession.getMapper(CityDAO.class);
        cityDAO.delete(city);
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    @CacheEvict(value = "cities", key = "#city.cityId")
    public void update(City city) {
//        CityDAO cityDAO = sqlSession.getMapper(CityDAO.class);
        cityDAO.update(city);
    }

//    public SqlSession getSqlSession() {
//        return sqlSession;
//    }
//
//    public void setSqlSession(SqlSession sqlSession) {
//        this.sqlSession = sqlSession;
//    }

    public CityDAO getCityDAO() {
        return cityDAO;
    }

    public void setCityDAO(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }
    
    

}
