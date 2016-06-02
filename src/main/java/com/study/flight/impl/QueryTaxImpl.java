/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.flight.impl;

import com.study.flight.AbstractQueryExecutor;
import com.study.flight.QueryTax;
import com.study.flight.model.QueryCondition;
import com.study.flight.model.QueryResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Colin_You
 */
@Service
public class QueryTaxImpl extends AbstractQueryExecutor implements QueryTax {

    private static final Logger LOGGER = Logger.getLogger(QueryTaxImpl.class);

    @Override
    protected void doQuery(QueryCondition con, QueryResult result) {
        LOGGER.info("Do tax quering");
    }

}
