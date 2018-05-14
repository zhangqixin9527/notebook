package com.hengba.test.common.time;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Kevin created on 2018/4/12
 */
public class CalendarTest {
    @Test
    void testAddDay(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(format.format(addDay(new Date(), 1)));
        System.out.println(format.format(addTime(new Date(), 3600000)));
    }

    public static Date addDay(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, offset);
        return calendar.getTime();
    }

    static Date addTime(Date date, int offset){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, offset);
        return calendar.getTime();
    }
}
