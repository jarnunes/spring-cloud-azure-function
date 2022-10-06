package com.jnunes.springcloud.suport;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

public class DateUtils {
    public static String dateTimeFormat(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(dateTime);
    }

    public static String dateTimeFormat(LocalDateTime dateTime) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("America/Sao_Paulo"));
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(zonedDateTime);
    }

    public static String dateTimeFormat(String dateTime) {
        return dateTimeFormat(toLocalDateTime(dateTime));
    }

    public static LocalDateTime toLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime);
    }

    public static LocalDate toLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Optional.ofNullable(StringUtils.trimToNull(date)).map(cleanDate -> LocalDate.parse(date, formatter))
            .orElse(null);
    }
}
