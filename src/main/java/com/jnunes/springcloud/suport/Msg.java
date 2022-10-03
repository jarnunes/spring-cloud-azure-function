package com.jnunes.springcloud.suport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.text.MessageFormat;
import java.util.HashMap;

@ApplicationScope
@Component
public class Msg extends HashMap<String, String> {

    private static final Logger log = LoggerFactory.getLogger(Msg.class);

    @Autowired
    @Lazy
    private MessageSource messageSource;

    private String getMessage(final String key) {
        try {
            return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            log.error(String.valueOf(e));
            return key;
        }
    }

    @Override
    public String get(Object key) {
        return this.getMessage((String) key);
    }

    public String get(String key, Object... params) {
        final MessageFormat format = new MessageFormat(this.getMessage(key));
        return format.format(params);
    }

}