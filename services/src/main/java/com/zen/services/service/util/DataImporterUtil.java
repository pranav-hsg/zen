package com.zen.services.service.util;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DataImporterUtil {

    public static String getBucketCode(String vertical, Integer dpd) {
        vertical = vertical.toUpperCase();
        String verticalCode = vertical;
        String bucketGroup = verticalCode.equals("AE") ? "AGRI" : "NON-AGRI";
        if(dpd <= 30)
            return "0-30";
        else if(dpd <= 60)
            return "30-60";
        else if(dpd <= 90)
            return "60-90";
        else if(dpd <= 120)
            return "90-120";
        else if(dpd <= 150)
            return "120-150";
        else if(dpd <= 180)
            return "150-180";
        else if(dpd <= 210)
            return "180-210";
        else if(dpd <= 240)
            return "210-240";
        else if(dpd <= 270)
            return "240-270";
        else if(dpd <= 330)
            return "300-330";
        else if(dpd <= 360)
            return "330-360";
        else
            return "360+";
//        else {
//            if(bucketGroup.equals("NON-AGRI"))
//                return "240+";
//            if(dpd <= 270)
//                return "240-270";
//            else if(dpd <= 330)
//                return "300-330";
//            else if(dpd <= 360)
//                return "330-360";
//            else
//                return "360+";
//        }
    }

    public static Integer getBucketNumber(String vertical, Integer dpd) {
        vertical = vertical.toUpperCase();
        String verticalCode = vertical;
        String bucketGroup = verticalCode.equals("AE") ? "AGRI" : "NON-AGRI";
        if(dpd <= 30)
            return 0;
        else if(dpd <= 60)
            return 1;
        else if(dpd <= 90)
            return 2;
        else if(dpd <= 120)
            return 3;
        else if(dpd <= 150)
            return 4;
        else if(dpd <= 180)
            return 5;
        else if(dpd <= 210)
            return 6;
        else if(dpd <= 240)
            return 7;
        else if(dpd <= 270)
            return 9;
        else if(dpd <= 330)
            return 10;
        else if(dpd <= 360)
            return 11;
        else
            return 12;
//        else {
//            if(bucketGroup.equals("NON-AGRI"))
//                return 8;
//            if(dpd <= 270)
//                return 9;
//            else if(dpd <= 330)
//                return 10;
//            else if(dpd <= 360)
//                return 11;
//            else
//                return 12;
//        }
    }

    public static String getBookCode(String vertical, BigDecimal ticketSize) {
        return vertical +"~~"+getTicketSizeStr(ticketSize);
    }

    public static String getTicketSizeStr(BigDecimal ticketSize) {
        if(ticketSize.compareTo(BigDecimal.valueOf(10000000)) < 0)
            return "up to 1 crore";
        else if(ticketSize.compareTo(BigDecimal.valueOf(30000000)) < 0)
            return "1 - 3 crores";
        else if(ticketSize.compareTo(BigDecimal.valueOf(50000000)) < 0)
            return "3 - 5 crores";
        else
            return "more than 5 crores";
    }

    public static LocalDate getMonthEndDate(LocalDate inDate) {
        return inDate.withDayOfMonth(
                inDate.getMonth().length(inDate.isLeapYear()));
    }

    public static String[] getHeaderArrayFromFileHeader(String header) {
        return header.split(",");
    }

    public static String[] getBucket(String vertical) {

        String[] plus240 = new String[]{"0-30", "31-60", "61-90", "91-120", "121-150", "151-180", "181-210", "211-240", "240+"};
        String[] plus360 = new String[]{"0-30", "31-60", "61-90", "91-120", "121-150", "151-180", "181-210", "211-240", "241-270", "271-300", "301-330", "331-360", "360+"};
//        if (vertical.equalsIgnoreCase("agri enterprises")) {
//            return agri;
//        }
//        else {
//            return non_agri;
//        }
        return plus360;
    }
}
