package com.jnunes.springcloud.suport;


import com.jnunes.springcloud.suport.config.StaticContextAccessor;

public class Utils {
    public static String getMessage(String key) {
        return StaticContextAccessor.getBean(Msg.class).get(key);
    }
}
