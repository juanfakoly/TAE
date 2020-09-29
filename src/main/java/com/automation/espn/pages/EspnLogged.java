package com.automation.espn.pages;

import com.automation.espn.utils.WaitUntilPageReloaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        driver.switchTo().defaultContent();
        WaitUntilPageReloaded.loading(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnUser));
        btnUser.click();
        return btnLogIn.isDisplayed();
    }
}
