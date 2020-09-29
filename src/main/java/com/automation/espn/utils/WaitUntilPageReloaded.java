package com.automation.espn.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WaitUntilPageReloaded {

    public static Boolean waitUntilPageReloaded(WebDriver driver) {
        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    }

}
