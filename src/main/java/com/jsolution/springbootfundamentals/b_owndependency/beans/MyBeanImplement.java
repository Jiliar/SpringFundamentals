package com.jsolution.springbootfundamentals.b_owndependency.beans;

import com.jsolution.springbootfundamentals.b_owndependency.beans.interfaces.MyBean;

public class MyBeanImplement implements MyBean {
    @Override
    public void print() {
        System.out.println("¡Hello from my own bean implementation!");
    }
}
