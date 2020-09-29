package com.automation.espn.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WaitUntilPageReloaded {

    private static int times = 0;

    private WaitUntilPageReloaded() {
    }

    private static Boolean waitUntilPageReloaded(WebDriver driver) {
        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    }

    public static void loading(WebDriver driver) {
        while (Boolean.TRUE.equals(waitUntilPageReloaded(driver))) {
            times++;
            if (times == 4000) {
                times = 0;
                break;
            }
        }
    }
}
