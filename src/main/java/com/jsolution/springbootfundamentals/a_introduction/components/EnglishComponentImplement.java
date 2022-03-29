package com.jsolution.springbootfundamentals.a_introduction.components;
import org.springframework.stereotype.Component;

@Component
public class EnglishComponentImplement implements ComponentDependency {
    @Override
    public void great() {
        System.out.println("¡Hello World from Component!");
    }
}
