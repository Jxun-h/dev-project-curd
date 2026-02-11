package com.dev.api.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Component
public class MessageUtils {

    private static MessageSource messageSource;

    @Autowired
    public MessageUtils(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    public static String getMessage(String code) {
        // Locale.KOREA를 기본으로 하되, 나중에 LocaleContextHolder에서 꺼내오면 다국어 대응 가능
        return messageSource.getMessage(code, null, Locale.KOREA);
    }

    public static String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.KOREA);
    }
}
