/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.cxf.common;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.log4j.Logger;
import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
 *
 * @author Colin_You
 */
public class ServerPasswordCallback implements CallbackHandler {

    private static final Logger LOGGER = Logger.getLogger(ServerPasswordCallback.class);

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            LOGGER.debug("Handling the server side password call back");
            WSPasswordCallback pc = (WSPasswordCallback) callback;
            if (pc.getUsage() == WSPasswordCallback.SIGNATURE
                    || pc.getUsage() == WSPasswordCallback.DECRYPT
                    || pc.getUsage() == WSPasswordCallback.USERNAME_TOKEN) {
                LOGGER.info("Getting requesting user ID is: " + pc.getIdentifier());
                // set the password on the callback. This will be compared to the
                // password which was sent from the client.
                pc.setPassword("Password4Privatekey");
            }
        }
    }

}
