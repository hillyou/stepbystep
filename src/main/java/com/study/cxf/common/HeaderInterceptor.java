/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.cxf.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJOutInterceptor;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptor;
import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 *
 * @author Colin_You
 */
public class HeaderInterceptor extends AbstractSoapInterceptor {

    private static final Logger LOGGER = Logger.getLogger(HeaderInterceptor.class);
    private final List<PhaseInterceptor<? extends Message>> extras = new ArrayList<>(1);

    public HeaderInterceptor() {
        super(Phase.PRE_STREAM);
        extras.add(new SAAJOutInterceptor());
    }

    @PostConstruct
    private void inital() {
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        try {
            Locale locale = LocaleContextHolder.getLocale();
            LOGGER.info("Header locale set to: " + locale);
            List<Header> headers = message.getHeaders();
            DataBinding dataBinding = new JAXBDataBinding(KeyValueHeader.class);
            QName qname = new QName("http://www.ceair.com/", "header", "request");
            KeyValueHeader localeHeader = new KeyValueHeader("country", locale.getCountry());
            headers.add(new Header(qname, localeHeader, dataBinding));
            localeHeader = new KeyValueHeader("language", locale.getLanguage());
            headers.add(new Header(qname, localeHeader, dataBinding));
        } catch (JAXBException ex) {
            LOGGER.error("Add header to SOAP message error", ex);
        }
    }

    @Override
    public Collection<PhaseInterceptor<? extends Message>> getAdditionalInterceptors() {
        return extras;
    }

}
