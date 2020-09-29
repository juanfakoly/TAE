package com.automation.espn.pages;

import com.automation.espn.utils.WaitUntilPageReloaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EspnDeleteAccount extends BasePage{

    private WebDriver driver;

    public EspnDeleteAccount(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id="global-user-trigger")
    private WebElement btnUser;

    @FindBy(css="li:nth-child(2) [tref='/members/v3_1/modifyAccount']")
    private WebElement btnModifyAccount;

    @FindBy(id="cancel-account")
    private WebElement btnDeleteAccount;

    @FindBy(css="[did-translate='deactivate.confirmation.buttons.confirm']")
    private WebElement btnDeleteConfirmation;

    @FindBy(css="#disneyid-wrapper #disneyid-iframe")
    private WebElement iframeSignIn;


    public EspnLogged deleteAccount() {
        WaitUntilPageReloaded.loading(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnUser));
        btnUser.click();
        btnModifyAccount.click();
        driver.switchTo().frame(iframeSignIn);
        WaitUntilPageReloaded.loading(driver);
        btnDeleteAccount.click();
        WaitUntilPageReloaded.loading(driver);
        btnDeleteConfirmation.click();
        WaitUntilPageReloaded.loading(driver);
        driver.switchTo().defaultContent();
        return new EspnLogged(getDriver());
    }
}
