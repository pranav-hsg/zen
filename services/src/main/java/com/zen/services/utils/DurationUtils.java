//package com.zen.services.utils;
//
//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class DurationUtils {
//
//    public static String toString(Duration duration) {
//        if(duration == null) return null;
//        boolean isNegative = duration.isNegative();
//        duration = duration.abs();
//        long days    = duration.toDaysPart();
//        long hours   = duration.toHoursPart();
//        long minutes = duration.toMinutesPart();
//        long seconds = duration.toSecondsPart();
//
//        String result = "";
//        if(days > 0)
//            result += days + (days == 1 ? " Day" : " Days");
//        if(hours > 0)
//            result += " " + hours + (hours == 1 ? " Hour" : " Hours");
//        if(minutes > 0)
//            result += " " + minutes + (minutes == 1 ? " Minute" : " Minutes");
//        if(seconds > 0)
//            result += " " + seconds + (seconds == 1 ? " Second" : " Seconds");
//        if(result.isEmpty())
//            return "0 Seconds";
//        if(isNegative)
//            result = "-" + result;
//        return result.trim();
//    }
//
//    public static String dateToString(LocalDate localDate) {
//        return Integer.toString(Integer.parseInt(DateTimeFormatter.BASIC_ISO_DATE.format(localDate)), Character.MAX_RADIX);
//    }
//
//}
