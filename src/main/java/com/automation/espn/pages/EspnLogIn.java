package com.automation.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class EspnLogIn extends BasePage {

    private WebDriver driver;

    public EspnLogIn(WebDriver driver) {
        super(driver);
        driver.get("https://www.espn.com/?src=com&_adblock=true");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
    }

    @FindBy(id="global-user-trigger")
    private WebElement btnUser;

    @FindBy(css="li:nth-child(2)  a[tref='/members/v3_1/login']")
    private WebElement btnLogIn;

    @FindBy(css="[ng-model='vm.username']")
    private WebElement txtUserName;

    @FindBy(css="[ng-model='vm.password']")
    private WebElement txtPassword;

    @FindBy(css="[did-translate='login.label.SIGNIN']")
    private WebElement btnEnter;

    @FindBy(css="#disneyid-wrapper #disneyid-iframe")
    private WebElement iframeSignIn;

    private void logIn(String username, String password) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnUser));
        btnUser.click();
        btnLogIn.click();
        driver.switchTo().frame(iframeSignIn);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(txtUserName));
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnEnter.click();
        driver.switchTo().defaultContent();
    }

    public EspnLogOut logInAndLogout(String username, String password) {
        logIn(username, password);
        return new EspnLogOut(getDriver());
    }

    public EspnDeleteAccount logInAndDeleteAccount(String username, String password) {
        logIn(username, password);
        return new EspnDeleteAccount(getDriver());
    }
}
