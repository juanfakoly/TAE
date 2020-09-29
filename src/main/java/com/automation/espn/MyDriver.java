package com.automation.espn;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyDriver {

    private WebDriver driver;

    public MyDriver(String browser)  {
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
