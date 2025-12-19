package com.example.cache.cache;

import org.jspecify.annotations.Nullable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component("commonKeyGenerator")
public class CommonKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, @Nullable Object... params) {
        String key =  String.join("_"+target.getClass().getSimpleName(),
                method.getName(), params[0]!=null?params[0].toString():null);
        System.out.println("KEY -> "+key);
        return key;
    }
}
