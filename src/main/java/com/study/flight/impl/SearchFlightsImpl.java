/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.flight.impl;

import com.study.flight.AbstractConcurrentFlightTaxSearchFlights;
import com.study.flight.QueryFare;
import com.study.flight.QueryFlights;
import com.study.flight.QueryTax;
import com.study.flight.model.QueryCondition;
import com.study.flight.model.QueryResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Colin_You
 */
@Service
public class SearchFlightsImpl extends AbstractConcurrentFlightTaxSearchFlights {

    private static final Logger LOGGER = Logger.getLogger(SearchFlightsImpl.class);
    @Autowired
    private QueryFlights queryFlights;
    @Autowired
    private QueryFare queryFare;
    @Autowired
    private QueryTax queryTax;

    @Override
    protected void queryFlights(QueryCondition con, QueryResult result) {
        queryFlights.execute(con, result);
    }

    @Override
    protected void queryFare(QueryCondition con, QueryResult result) {
        queryFare.execute(con, result);
    }

    @Override
    protected void queryTax(QueryCondition con, QueryResult result) {
        queryTax.execute(con, result);
    }

}
