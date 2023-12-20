package com.saberspringcore.test.model;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

@Data
public class Singer implements InitializingBean , BeanNameAware {

    private static final String DEFAULT_NAME = "No Name";
    private String name;
    private Integer age;

    public void setName(String name) {
        System.out.println("Calling setName for bran of type  " + Singer.class);
        this.name = name;
    }

    public void setAge(Integer age) {
        System.out.println("Calling setAge for bran of type  " + Singer.class);
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean");

        if (name == null) {
            System.out.println("using default name");
            name = DEFAULT_NAME;
        }
        if (age == null) {
            throw new IllegalArgumentException("You must set the age property of any beans of type " + Singer.class);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
       // init();
    }

    @Override
    public void setBeanName(String name) {
        this.name=name;
    }
}
