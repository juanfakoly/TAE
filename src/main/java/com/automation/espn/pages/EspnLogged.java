package com.automation.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.automation.espn.utils.WaitUntilPageReloaded.waitUntilPageReloaded;

public class EspnLogged extends BasePage {

    private WebDriver driver;

    public EspnLogged(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id="global-user-trigger")
    private WebElement btnUser;

    @FindBy(css=".display-user span")
    private WebElement userName;

    @FindBy(css="li:nth-child(2)  a[tref='/members/v3_1/login']")
    private WebElement btnLogIn;

    public Boolean notlogged() {
        while (waitUntilPageReloaded(driver)) {
            Logger.getLogger("wait").log(Level.INFO, "loading");
        }
        driver.switchTo().defaultContent();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnUser));
        btnUser.click();
        return btnLogIn.isDisplayed();
    }
}
