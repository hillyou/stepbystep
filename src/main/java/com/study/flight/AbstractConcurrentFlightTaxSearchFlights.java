/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.flight;

import com.study.flight.model.QueryCondition;
import com.study.flight.model.QueryResult;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Colin_You
 */
public abstract class AbstractConcurrentFlightTaxSearchFlights extends AbstractSearchFlights {

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    @Override
    protected final void queryFareAndTax(final QueryCondition con, final QueryResult result) {
        try {
            Future<Boolean> fareResult = executorService.submit(new Runnable() {
                public void run() {
                    queryFare(con, result);
                }
            }, true);

            Future<Boolean> taxResult = executorService.submit(new Runnable() {
                public void run() {
                    queryTax(con, result);
                }
            }, true);

            boolean isCompete = fareResult.get() && taxResult.get();

        } catch (InterruptedException ex) {
            Logger.getLogger(AbstractConcurrentFlightTaxSearchFlights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(AbstractConcurrentFlightTaxSearchFlights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setPoolSize(int size) {
        executorService = Executors.newFixedThreadPool(size);
    }

    protected abstract void queryFare(QueryCondition con, QueryResult result);

    protected abstract void queryTax(QueryCondition con, QueryResult result);
}
