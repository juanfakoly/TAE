package com.automation.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.automation.espn.utils.WaitUntilPageReloaded.waitUntilPageReloaded;

public class EspnLogOut extends BasePage {

    private WebDriver driver;

    public EspnLogOut(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id="global-user-trigger")
    private WebElement btnUser;

    @FindBy(css="li:nth-child(2) [onclick='javascript:espn.memberservices.logout();return false;']")
    private WebElement btnLogOut;

    @FindBy(css=".display-user span")
    private WebElement userName;


    public EspnLogged logOut() {
        driver.switchTo().defaultContent();
        while (waitUntilPageReloaded(driver)) {
            Logger.getLogger("wait").log(Level.INFO, "loading");
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnUser));
        btnUser.click();
        setUserName(userName);
        btnLogOut.click();
        return new EspnLogged(getDriver());
    }

    public WebElement getUserName() {
        return userName;
    }

    public void setUserName(WebElement userName) {
        this.userName = userName;
    }
}
