/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.flight.impl;

import com.study.flight.AbstractQueryExecutor;
import com.study.flight.QueryFlights;
import com.study.flight.model.QueryCondition;
import com.study.flight.model.QueryResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Colin_You
 */
@Service
public class QueryFlightsImpl extends AbstractQueryExecutor implements QueryFlights {

    private static final Logger LOGGER = Logger.getLogger(QueryFlightsImpl.class);

    @Override
    protected void doQuery(QueryCondition con, QueryResult result) {
        LOGGER.info("Do flights quering");
    }

}
