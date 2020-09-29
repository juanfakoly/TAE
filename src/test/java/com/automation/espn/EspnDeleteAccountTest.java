package com.automation.espn;

import com.automation.espn.pages.EspnDeleteAccount;
import com.automation.espn.pages.EspnLogIn;
import com.automation.espn.pages.EspnLogged;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EspnDeleteAccountTest extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void espnDeleteAccount(String email, String password) throws InterruptedException {
        EspnLogIn espnLogIn = getEspnLogIn();
        EspnDeleteAccount espnDeleteAccount = espnLogIn.logInAndDeleteAccount(email, password);
        EspnLogged espnLogged = espnDeleteAccount.deleteAccount();
        Assert.assertTrue(espnLogged.notlogged());
    }
}
