package com.example.mproject.webservice.service.impl;

import com.example.mproject.webservice.service.HelloWebService;
import org.springframework.context.annotation.Configuration;

import javax.jws.WebService;

@WebService(
        targetNamespace = "webservice.mproject.example.com", //wsdl命名空间
        serviceName = "HelloWebService",                 //portType名称 客户端生成代码时 为接口名称
        endpointInterface = "com.example.mproject.webservice.service.HelloWebService")//指定发布webservcie的接口类，此类也需要接入@WebService注解
@Configuration
public class HelloWebServiceImpl implements HelloWebService {
    @Override
    public String Hello(String name) {
        System.out.println("欢迎你"+name);
        return "欢迎你"+name;
    }
}
