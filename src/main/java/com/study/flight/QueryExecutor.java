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
public interface QueryExecutor {

    void execute(QueryCondition con, QueryResult result);

}
