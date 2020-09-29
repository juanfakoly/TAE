package com.automation.espn;

import com.automation.espn.pages.EspnLogIn;
import com.automation.espn.pages.EspnSignIn;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {

    private MyDriver myDriver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeClass(String browser) {
        this.myDriver = new MyDriver(browser);
    }

    public EspnSignIn getEspnSignIn() {
        return new EspnSignIn(myDriver.getDriver());
    }

    public EspnLogIn getEspnLogIn() {
        return new EspnLogIn(myDriver.getDriver());
    }

   @AfterClass(alwaysRun = true)
    public void afterClass() {
        myDriver.getDriver().quit();
    }
}
