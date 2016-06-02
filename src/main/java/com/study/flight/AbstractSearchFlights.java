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
public abstract class AbstractSearchFlights extends AbstractQueryExecutor {

    @Override
    public final void doQuery(QueryCondition con, QueryResult result) {
        queryFlights(con, result);
        queryFareAndTax(con, result);
    }

    protected abstract void queryFlights(QueryCondition con, QueryResult result);

    protected abstract void queryFareAndTax(QueryCondition con, QueryResult result);

}
