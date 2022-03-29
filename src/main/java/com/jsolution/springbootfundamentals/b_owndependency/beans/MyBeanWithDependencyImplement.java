package com.jsolution.springbootfundamentals.b_owndependency.beans;

import com.jsolution.springbootfundamentals.b_owndependency.beans.interfaces.MyBeanWithDependency;
import com.jsolution.springbootfundamentals.b_owndependency.beans.interfaces.MyOperation;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    @Autowired
    MyOperation myOperation;

    @Override
    public void printWithDependencyImplement() {
        int number = 5;
        System.out.println(myOperation.sum(number));
        System.out.println("¡Hello from bean implementation with dependency!");
    }
}
