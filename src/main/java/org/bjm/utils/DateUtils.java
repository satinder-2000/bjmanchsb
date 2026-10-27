package org.bjm.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class DateUtils {

    private static final DateTimeFormatter HTML_FORMAT =
            DateTimeFormatter.ISO_LOCAL_DATE;

    private static final DateTimeFormatter UK_IN_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/uuuu");

    private static final DateTimeFormatter US_FORMAT =
            DateTimeFormatter.ofPattern("MM/dd/uuuu");

    private DateUtils() {
        // Prevent object creation
    }

    // HTML5 ISO string -> LocalDate
    public static LocalDate fromHtmlDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        return LocalDate.parse(value, HTML_FORMAT);
    }

    // LocalDate -> HTML5 ISO string
    public static String toHtmlDate(LocalDate date) {
        if (date == null) {
            return "";
        }

        return date.format(HTML_FORMAT);
    }

    // LocalDate -> British / Indian format
    public static String toUkIndianDate(LocalDate date) {
        if (date == null) {
            return "";
        }

        return date.format(UK_IN_FORMAT);
    }

    // LocalDate -> US format
    public static String toUsDate(LocalDate date) {
        if (date == null) {
            return "";
        }

        return date.format(US_FORMAT);
    }

    // British / Indian string -> LocalDate
    public static LocalDate fromUkIndianDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        return LocalDate.parse(value, UK_IN_FORMAT);
    }

    // US string -> LocalDate
    public static LocalDate fromUsDate(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        return LocalDate.parse(value, US_FORMAT);
    }
    
    public static LocalDate parseDate(String date) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.UK);
    	LocalDate localDate= LocalDate.parse(date,formatter);
    	return localDate;
    }
    
    public static String parseString(LocalDate date) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.UK);
    	return formatter.format(date);
    }
}
