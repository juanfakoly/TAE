package com.automation.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFor extends BasePage {

    private WebDriver driver;

    public SearchFor(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "ss")
    private WebElement txtDestination;

    @FindBy(css = "[data-label='Bogotá, Colombia']")
    private WebElement btnDestination;

    public Accommodation destination(String destination) {
        txtDestination.sendKeys(destination);
        btnDestination.click();
        return new Accommodation(driver);
    }
}
