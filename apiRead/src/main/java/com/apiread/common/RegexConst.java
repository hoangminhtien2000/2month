package com.apiread.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class RegexConst {

    @Autowired
    private MessageSource messageSource;

    public final String stt ="\\b[1-9][0-9]{0,2}\\b";
    public final String names ="^[a-zA-Z0-9 ]+$";
    public final String birthday ="yyyy-MM-dd";
    public final String address ="^[a-zA-Z0-9 ]+$";
    public final String classroom ="[a-zA-Z0-9 ]{1,10}";
    public final String school ="[a-zA-Z1-9 ]{1,10}";
    public final String phone ="(03|05|07|08|09)+([0-9]{8})";
    public final String email ="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public String message(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, null, locale);
    }

}
