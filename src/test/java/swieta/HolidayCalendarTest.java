package swieta;

import junit.framework.Assert;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
public class HolidayCalendarTest {
    @Test
    public void testIsHoliday() throws Exception {
        List<LocalDate> holidayDates = new ArrayList<LocalDate>();

        // sundays
//        holidayDates.add(createDate(26, 1, 2014));
//        holidayDates.add(createDate(5, 1, 2014));
//        holidayDates.add(createDate(2, 3, 2014));
//
//        // holidays
//        holidayDates.add(createDate(1, 1));
//        holidayDates.add(createDate(6, 1));
//        holidayDates.add(createDate(1, 5));
//        holidayDates.add(createDate(3, 5));
//        holidayDates.add(createDate(15, 8));
//        holidayDates.add(createDate(1, 11));
//        holidayDates.add(createDate(11, 11));
//        holidayDates.add(createDate(25, 12));
//        holidayDates.add(createDate(26, 12));

        // Easter monday i Corpus Christi
       holidayDates.add(createDate(21, 4, 2014));
       holidayDates.add(createDate(19, 6, 2014));

        for (LocalDate holidayDate : holidayDates) {
            Assert.assertTrue(HolidayCalendar.isHoliday(holidayDate));
        }
    }

    private LocalDate createDate(int dayOfMonth, int monthOfYear) {
        return new LocalDate().withDayOfMonth(dayOfMonth).withMonthOfYear(monthOfYear);
    }

    private LocalDate createDate(int dayOfMonth, int monthOfYear, int year) {
        return new LocalDate().withDayOfMonth(dayOfMonth).withMonthOfYear(monthOfYear).withYear(year);
    }
}
