/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.flight;

import com.study.flight.model.QueryCondition;
import com.study.flight.model.QueryResult;

/**
 *
 * @author Colin_You
 */
public abstract class AbstractSequenceFlightTaxSearchFlights extends AbstractSearchFlights {

    @Override
    protected final void queryFareAndTax(QueryCondition con, QueryResult result) {
        queryFare(con, result);
        queryTax(con, result);
    }

    protected abstract void queryFare(QueryCondition con, QueryResult result);

    protected abstract void queryTax(QueryCondition con, QueryResult result);
}
