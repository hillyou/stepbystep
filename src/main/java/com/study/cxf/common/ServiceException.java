/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.cxf.common;

import javax.xml.ws.WebFault;

/**
 *
 * @author yougu
 */
@WebFault(name = "CustumFault", faultBean = "com.study.cxf.common.FaultBean")
public class ServiceException extends Exception {

    private static final long serialVersionUID = -980672610145187140L;
    private FaultBean faultBean;

     public ServiceException() {
        super();
    }
    
    public ServiceException(String message, FaultBean faultInfo) {
        super(message);
        this.faultBean = faultInfo;
    }

    public ServiceException(String message, FaultBean faultInfo, Throwable cause) {
        super(message, cause);
        this.faultBean = faultInfo;
    }

    public FaultBean getFaultInfo() {
        return faultBean;
    }
}
