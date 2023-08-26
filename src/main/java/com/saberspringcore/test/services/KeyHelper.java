package com.saberspringcore.test.services;

import org.springframework.aop.scope.ScopedProxyFactoryBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class KeyHelper {
    public void open(){
        //System.out.println("open method called ....................");
    }
}
