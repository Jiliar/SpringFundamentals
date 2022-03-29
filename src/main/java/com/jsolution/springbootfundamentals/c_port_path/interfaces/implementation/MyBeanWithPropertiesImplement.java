package com.jsolution.springbootfundamentals.c_port_path.interfaces.implementation;

import com.jsolution.springbootfundamentals.c_port_path.interfaces.MyBeanWithProperties;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

    private String name;
    private String lastname;
    private String random;

    public MyBeanWithPropertiesImplement(String name, String lastname, String random) {
        this.name = name;
        this.lastname = lastname;
        this.random = random;
    }

    @Override
    public String function() {
        return "Name: "+name+" - Last Name: "+lastname+" - ID: "+random;
    }
}
