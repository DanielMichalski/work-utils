package holidays;

import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Author: Daniel
 */
public class HolidayDateUtilTest {
    @Test
    public void testHolidayDays() {
        List<LocalDate> holidayDates = new ArrayList<LocalDate>();

        // sundays
        holidayDates.add(DateUtil.createDate(26, 1, 2014));
        holidayDates.add(DateUtil.createDate(5, 1, 2014));
        holidayDates.add(DateUtil.createDate(2, 3, 2014));

        // holidays
        holidayDates.add(DateUtil.createDate(1, 1));
        holidayDates.add(DateUtil.createDate(6, 1));
        holidayDates.add(DateUtil.createDate(1, 5));
        holidayDates.add(DateUtil.createDate(3, 5));
        holidayDates.add(DateUtil.createDate(15, 8));
        holidayDates.add(DateUtil.createDate(1, 11));
        holidayDates.add(DateUtil.createDate(11, 11));
        holidayDates.add(DateUtil.createDate(25, 12));
        holidayDates.add(DateUtil.createDate(26, 12));

        // Easter Monday i Corpus Christi
        holidayDates.add(DateUtil.createDate(21, 4, 2014));
        holidayDates.add(DateUtil.createDate(19, 6, 2014));

        for (LocalDate holidayDate : holidayDates) {
            assertTrue(HolidayDateUtil.isHoliday(holidayDate));
        }
    }

    @Test
    public void testNonHolidayDays() {
        List<LocalDate> nonHolidayDates = new ArrayList<LocalDate>();

        nonHolidayDates.add(null);

        nonHolidayDates.add(DateUtil.createDate(28, 1, 2014));
        nonHolidayDates.add(DateUtil.createDate(13, 1, 2014));
        nonHolidayDates.add(DateUtil.createDate(22, 3, 2014));

        nonHolidayDates.add(DateUtil.createDate(3, 3, 2014));
        nonHolidayDates.add(DateUtil.createDate(15, 3, 2014));
        nonHolidayDates.add(DateUtil.createDate(12, 12, 2014));
        nonHolidayDates.add(DateUtil.createDate(13, 12, 2014));
        nonHolidayDates.add(DateUtil.createDate(5, 5, 2014));
        nonHolidayDates.add(DateUtil.createDate(15, 1, 2015));

        for (LocalDate holidayDate : nonHolidayDates) {
            assertFalse(HolidayDateUtil.isHoliday(holidayDate));
        }
    }
}
