package com.example.mproject.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 创建服务接口
 */
@WebService()
public interface HelloWebService {
    @WebMethod
    public String Hello(@WebParam(name="name") String name);
}
