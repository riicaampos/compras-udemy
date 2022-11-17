package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello(){
        return "hello worlds";
    }

    public Integer soma(Integer a, Integer b){
        return a+b;
    }

}
