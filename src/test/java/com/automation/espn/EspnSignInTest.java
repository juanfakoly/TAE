package com.automation.espn;

import com.automation.espn.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EspnSignInTest extends BaseTest  {

    @Test
    @Parameters({"firstName", "lastName", "email", "password"})
    public void espnSignInTest(String firstName, String lastName, String email, String password) {
        EspnSignIn espnSignIn = getEspnSignIn();
        EspnLogOut espnLogOut = espnSignIn.signIn(firstName, lastName, email, password);
        EspnLogged espnLogged = espnLogOut.logOut();
        Assert.assertEquals(espnLogOut.getUserName().getText(), firstName + "!");
        Assert.assertTrue(espnLogged.notlogged());
    }
}
