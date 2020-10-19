package com.automation.booking.utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchWindow {

    private  SwitchWindow() {
    }

    public static boolean switchWindow(WebDriver driver) {

        String mainWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(mainWindow)) {
                driver.close();
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                return true;
            } else {
                driver.switchTo().window(mainWindow);
            }
        }
        return false;
    }
}
