package com.zen.services.service.util;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ECLUtil {

    public static int MAX_NUM_MONTHS = 36;

    public static List<LocalDate> getMaxMonthEndDateList(LocalDate date, int maxSets) {
        List<LocalDate> monthEndDates = new ArrayList<>();
        for (int i = 0; i < maxSets ; i++) {
            monthEndDates.add(date.minusMonths(i).with(TemporalAdjusters.lastDayOfMonth()));
        }
        Collections.reverse(monthEndDates);
        return monthEndDates;
    }

    public static  LocalDate getMonthEndDate(LocalDate inDate) {
        LocalDate monthEndDate = inDate.withDayOfMonth(inDate.lengthOfMonth());
        if(monthEndDate.equals(inDate)) {
            return inDate;
        }
        return inDate.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
    }
}
