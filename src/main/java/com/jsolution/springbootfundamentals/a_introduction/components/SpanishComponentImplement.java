package com.jsolution.springbootfundamentals.a_introduction.components;
import org.springframework.stereotype.Component;

@Component
public class SpanishComponentImplement implements ComponentDependency {
    @Override
    public void great() {
        System.out.println("¡Hola mundo desde el componente!");
    }
}
