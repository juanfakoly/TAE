package com.automation.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EspnSignIn extends BasePage {

    private WebDriver driver;

    public EspnSignIn(WebDriver driver) {
        super(driver);
        driver.get("https://www.espn.com/?src=com&_adblock=true");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
    }

    @FindBy(id="global-user-trigger")
    private WebElement btnUser;

    @FindBy(css="li:nth-child(2) [tref='/members/v3_1/login']")
    private WebElement btnLogIn;

    @FindBy(css="[did-translate='login.label.CREATE_ACCOUNT']")
    private WebElement btnSignIn;

    @FindBy(css="#disneyid-wrapper #disneyid-iframe")
    private WebElement iframeSignIn;

    @FindBy(css="[name='firstName']")
    private WebElement txtName;

    @FindBy(css="[name='lastName']")
    private WebElement txtLastName;

    @FindBy(css="[name='email']")
    private WebElement txtEmail;

    @FindBy(css="[name='newPassword']")
    private WebElement txtNewPassword;

    @FindBy(css="[did-translate='create.SIGN_UP']")
    private WebElement btnCreateAccount;

    private List<WebElement> webElementList() {
        List<WebElement> webElementList = new ArrayList<>();
        webElementList.add(txtName);
        webElementList.add(txtLastName);
        webElementList.add(txtEmail);
        webElementList.add(txtNewPassword);
        return webElementList;
    }

    public EspnLogOut signIn(String firstName, String lastName, String email, String password) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnUser));
        btnUser.click();
        btnLogIn.click();
        driver.switchTo().frame(iframeSignIn);
        btnSignIn.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframeSignIn);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(txtName));
        txtName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        txtNewPassword.sendKeys(password);
        btnCreateAccount.submit();
        driver.switchTo().defaultContent();
        return new EspnLogOut(getDriver());
    }
}
