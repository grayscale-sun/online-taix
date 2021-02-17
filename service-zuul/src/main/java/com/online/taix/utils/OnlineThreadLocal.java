package com.online.taix.utils;

import org.springframework.stereotype.Component;

@Component
public class OnlineThreadLocal{

    private static final ThreadLocal local = new ThreadLocal();

    public static <T> void set(T t){
        local.set(t);
    }

    public static <T> T get(){
        return (T) local.get();
    }
}
