package com.hengba.test.common;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Kevin created on 2017/10/10
 */
public class RuntimeClazz {
    public static void main(String[] args) {
        new RuntimeClazz().start();
        System.out.println("The Application is doing something");

        try
        {
            TimeUnit.MILLISECONDS.sleep(5000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void start()
    {
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                System.out.println("Execute Hook....."))
        );
    }

    @Test
    void test() throws ParseException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-10-20 00:00:00").getTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-10-21 00:00:00").getTime());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-10-22 00:00:00").getTime());

        System.out.println(new Date().getTime());
    }
}
