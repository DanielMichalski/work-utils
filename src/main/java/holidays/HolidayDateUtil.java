package holidays;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daniel
 */
public class HolidayDateUtil {
    public static boolean isHoliday(LocalDate date) {
        if (date == null) return false;

        int dayOfWeek = date.getDayOfWeek();
        int dayOfMonth = date.getDayOfMonth();
        int monthOfYear = date.getMonthOfYear();
        int year = date.getYear();

        if (dayOfWeek == DateTimeConstants.SUNDAY) return true;

        List<LocalDate> holidayDates = getHolidayDates();
        for (LocalDate holidayDate : holidayDates) {
            if (dayOfMonth == holidayDate.getDayOfMonth() &&
                    monthOfYear == holidayDate.getMonthOfYear()) {
                return true;
            }
        }

        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (a * 19 + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        if (d == 29 && e == 6) d -= 7;
        if (d == 28 && e == 6 && a > 10) d -= 7;
        LocalDate easter = new LocalDate(year, 3, 22).plusDays(d + e);
        if (date.minusDays(1).equals(easter))
            return true;                        // Easter Monday
        if (date.minusDays(60).equals(easter))
            return true;                        // Corpus Christi

        return false;
    }

    private static List<LocalDate> getHolidayDates() {
        List<LocalDate> holidaysDates = new ArrayList<LocalDate>();

        holidaysDates.add(DateUtil.createDate(1, 1));
        holidaysDates.add(DateUtil.createDate(6, 1));
        holidaysDates.add(DateUtil.createDate(1, 5));
        holidaysDates.add(DateUtil.createDate(3, 5));
        holidaysDates.add(DateUtil.createDate(15, 8));
        holidaysDates.add(DateUtil.createDate(1, 11));
        holidaysDates.add(DateUtil.createDate(11, 11));
        holidaysDates.add(DateUtil.createDate(25, 12));
        holidaysDates.add(DateUtil.createDate(26, 12));

        return holidaysDates;
    }
}