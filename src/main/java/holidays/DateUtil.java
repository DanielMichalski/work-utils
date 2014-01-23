package holidays;

import org.joda.time.LocalDate;

/**
 * Author: Daniel
 */
public class DateUtil {
    public static LocalDate createDate(int dayOfMonth, int monthOfYear) {
        return new LocalDate().withDayOfMonth(dayOfMonth).withMonthOfYear(monthOfYear);
    }

    public static LocalDate createDate(int dayOfMonth, int monthOfYear, int year) {
        return new LocalDate().withDayOfMonth(dayOfMonth).withMonthOfYear(monthOfYear).withYear(year);
    }
}
