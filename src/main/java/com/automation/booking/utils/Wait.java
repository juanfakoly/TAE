package com.automation.booking.utils;

import java.util.concurrent.TimeUnit;

public class Wait {

    public static void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
