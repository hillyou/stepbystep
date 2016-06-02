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
public abstract class AbstractQueryExecutor implements QueryExecutor {

    @Override
    public void execute(QueryCondition con, QueryResult result) {
        preQuery(con, result);
        doQuery(con, result);
        postQuery(con, result);
    }

    protected abstract void doQuery(QueryCondition con, QueryResult result);

    protected void preQuery(QueryCondition con, QueryResult result) {

    }

    protected void postQuery(QueryCondition con, QueryResult result) {

    }

}
