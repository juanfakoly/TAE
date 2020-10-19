package com.automation.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SelectTab extends BasePage {

    private WebDriver driver;

    public SelectTab(WebDriver driver) {
        super(driver);
        driver.get("https://www.booking.com/index.es.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
    }

    @FindBy(css = "[data-et-click='goal:xpb_accommodation goal:xpb_total_clicks']")
    private WebElement btnDormir;

    public SearchFor stay() {
        btnDormir.click();
        return new SearchFor(driver);
    }

}
