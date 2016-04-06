/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author Colin.You
 */
public class DBSessionFactory {

    private static final Map<String, SqlSessionFactory> DB_SESSION_FACTORY_MAP = new ConcurrentHashMap<String, SqlSessionFactory>();
    private static final String CONFIG_RESOURCE = "mybatis-config.xml";
    private final String env;

    public DBSessionFactory(String env) {
        this.env = env;
    }

    public synchronized SqlSessionFactory getSqlSessionFactory() {
        if (env == null || env.trim().isEmpty()) {
            throw new RuntimeException("ERROR, environment must not be empty");
        }
        if (DB_SESSION_FACTORY_MAP.containsKey(env)) {
            return DB_SESSION_FACTORY_MAP.get(env);
        }
        return createSqlSessionFactory(env);
    }

    public static SqlSessionFactory getDefaultSqlSessionFactory() {
        return createSqlSessionFactory(null);
    }

    private synchronized static SqlSessionFactory createSqlSessionFactory(String env) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(CONFIG_RESOURCE);
            SqlSessionFactory sessionFactory;
            if (env == null) {
                sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } else {
                sessionFactory = new SqlSessionFactoryBuilder().build(inputStream, env);
            }
            DB_SESSION_FACTORY_MAP.put(sessionFactory.getConfiguration().getEnvironment().getId(), sessionFactory);
            return sessionFactory;
        } catch (IOException ex) {
            Logger.getLogger(DBSessionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(DBSessionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
