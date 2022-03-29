package com.jsolution.springbootfundamentals.b_owndependency.beans.configuration;

import com.jsolution.springbootfundamentals.b_owndependency.beans.MyBeanImplement;
import com.jsolution.springbootfundamentals.b_owndependency.beans.MyBeanWithDependencyImplement;
import com.jsolution.springbootfundamentals.b_owndependency.beans.MyOperationImplement;
import com.jsolution.springbootfundamentals.b_owndependency.beans.interfaces.MyBean;
import com.jsolution.springbootfundamentals.b_owndependency.beans.interfaces.MyOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigBean {

    @Bean
    public MyBean beanOperation1(){
        return new MyBeanImplement();
    }

    @Bean
    public MyOperation beanOperation2(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependencyImplement beanOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement();
    }
}
