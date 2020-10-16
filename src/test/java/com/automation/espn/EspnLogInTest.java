package com.automation.espn;

import com.automation.espn.pages.EspnLogIn;
import com.automation.espn.pages.EspnLogOut;
import com.automation.espn.pages.EspnLogged;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EspnLogInTest extends BaseTest {

    @Test
    @Parameters({"firstName","email", "password"})
    public void espnLogInTest(String firstName, String email, String password) {
        EspnLogIn espnLogIn = getEspnLogIn();
        EspnLogOut espnLogOut = espnLogIn.logInAndLogout(email, password);
        EspnLogged espnLogged = espnLogOut.logOut();
        Assert.assertEquals(espnLogOut.getUserNameText(), firstName + "!");
        Assert.assertTrue(espnLogged.notlogged());
    }
}
