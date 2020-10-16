package com.automation.espn.pages;

import com.automation.espn.utils.WaitUntilPageReloaded;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EspnLogOut extends BasePage {

    private WebDriver driver;
    private String userNameText;

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
        WaitUntilPageReloaded.loading(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(btnUser));
        btnUser.click();
        setUserNameText(userName.getText());
        btnLogOut.click();
        return new EspnLogged(getDriver());
    }

    public String getUserNameText() {
        return userNameText;
    }

    public void setUserNameText(String userNameText) {
        this.userNameText = userNameText;
    }
}
