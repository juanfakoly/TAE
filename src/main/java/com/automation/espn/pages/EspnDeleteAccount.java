package com.automation.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.automation.espn.utils.WaitUntilPageReloaded.waitUntilPageReloaded;

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

    @FindBy(css="[did-translate='shared.buttons.ok']")
    private WebElement btnOK;

    @FindBy(css="#disneyid-wrapper #disneyid-iframe")
    private WebElement iframeSignIn;


    public EspnLogged deleteAccount() throws InterruptedException {
        while (waitUntilPageReloaded(driver)) {
            Logger.getLogger("wait").log(Level.INFO, "loading");
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnUser));
        btnUser.click();
        btnModifyAccount.click();
        driver.switchTo().frame(iframeSignIn);
        TimeUnit.SECONDS.sleep(2);
        btnDeleteAccount.click();
        TimeUnit.SECONDS.sleep(2);
        btnDeleteConfirmation.click();
        TimeUnit.SECONDS.sleep(2);
        btnOK.click();
        driver.switchTo().defaultContent();
        return new EspnLogged(getDriver());
    }
}
