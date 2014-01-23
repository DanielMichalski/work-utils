package holidays;

import org.joda.time.LocalDate;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

/**
 * Author: Daniel
 */
public class DateUtilTest {
    @Test
    public void testCreateDate() throws Exception {
        LocalDate date;

        date = DateUtil.createDate(4, 5);
        assertEquals(new LocalDate().withDayOfMonth(4).withMonthOfYear(5), date);
        assertNotSame(new LocalDate().withDayOfMonth(3).withMonthOfYear(1), date);

        date = DateUtil.createDate(3, 6, 2014);
        assertEquals(new LocalDate().withDayOfMonth(3).withMonthOfYear(6).withYear(2014), date);
        assertNotSame(new LocalDate().withDayOfMonth(4).withMonthOfYear(2).withYear(2014), date);
    }
}
