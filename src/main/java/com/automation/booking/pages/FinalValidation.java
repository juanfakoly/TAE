package com.automation.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinalValidation extends BasePage {

    private WebDriver driver;
    private Boolean elementsDisplayed;

    public FinalValidation(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    @FindBy(css = "[data-component='core/animate-price']")
    private WebElement txtReservationPrice;


    @FindBy(css = "[name='book']")
    private WebElement btnCompleteReservation;

    @FindBy(css = ".bui-u-text-right")
    private WebElement txtMessage;

    public FinalValidation success() {
        setElementsDisplayed(btnCompleteReservation.isDisplayed()
                && txtMessage.getText().equals("¡No te preocupes! No pagarás hasta que te alojes")
                && txtReservationPrice.isDisplayed());
        return new FinalValidation(driver);
    }


    public Boolean getElementsDisplayed() {
        return elementsDisplayed;
    }

    public void setElementsDisplayed(Boolean elementsDisplayed) {
        this.elementsDisplayed = elementsDisplayed;
    }

}
