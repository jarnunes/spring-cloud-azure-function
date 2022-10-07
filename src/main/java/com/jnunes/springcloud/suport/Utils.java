package com.jnunes.springcloud.suport;


import com.jnunes.springcloud.suport.config.StaticContextAccessor;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class Utils {
    public static String getMessage(String key) {
        return StaticContextAccessor.getBean(Msg.class).get(key);
    }

    public static String getMessage(String key, Object... params) {
        return StaticContextAccessor.getBean(Msg.class).get(key, params);
    }

    public static Integer toIntOrNull(String value) {
        return Optional.ofNullable(value).map(Utils::getDigitos).map(StringUtils::trimToNull)
            .map(Integer::parseInt).orElse(null);
    }

    public static Long toLongOrNull(String value) {
        return Optional.ofNullable(value).map(Utils::getDigitos).map(StringUtils::trimToNull)
                .map(Long::parseLong).orElse(null);
    }

    public static String getDigitos(String strValue) {
        return Optional.ofNullable(strValue)
            .map(str -> str.replaceAll("\\D", StringUtils.EMPTY)).orElse(null);
    }
}
