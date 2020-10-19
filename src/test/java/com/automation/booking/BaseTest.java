package com.automation.booking;

import com.automation.booking.pages.SelectTab;
import com.automation.booking.utils.MyDriver;
import org.testng.annotations.*;

public class BaseTest {

    private MyDriver myDriver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeClass(String browser) {
        this.myDriver = new MyDriver(browser);
    }

    public SelectTab getSelectTab() {return new SelectTab(myDriver.getDriver());}

   @AfterSuite(alwaysRun = true)
    public void afterClass() {
        myDriver.getDriver().quit();
    }
}
