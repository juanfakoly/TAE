package com.automation.booking.pages;

import com.automation.booking.utils.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SelectHotel extends BasePage{

    private WebDriver driver;
    private WebDriverWait wait;
    private String reservation;
    private Boolean elementsDisplayed;

    public SelectHotel(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[data-id='class-5']")
    private WebElement btnStars;

    @FindBy(css = ".sr_item:nth-child(3) .sr-hotel__name")
    private WebElement txtHotelName;

    @FindBy(css = ".sr_item:nth-child(3) .bui-review-score__badge")
    private WebElement txtScore;

    @FindBy(css = ".sr_item:nth-child(3) .bui-price-display__label")
    private WebElement txtReservation;

    @FindBy(css = ".sr_item:nth-child(3) .bui-price-display__value")
    private WebElement txtReservationPrice;

    @FindBy(css = ".sr_item:nth-child(3) .sr-cta-button-row")
    private WebElement btnChooseRoom;


    public ConfirmReservation andRooms() {
        btnStars.click();
        Wait.wait(7);
        setElementsDisplayed(hotelFeaturesDisplayed(txtHotelName, txtScore, txtReservationPrice));
        setReservation(txtReservation.getText());
        btnChooseRoom.click();
        return new ConfirmReservation(driver);
    }

    public Boolean hotelFeaturesDisplayed(WebElement txtHotelName, WebElement txtScore, WebElement txtReservationPrice) {
        return txtHotelName.isDisplayed() && txtScore.isDisplayed()
                && txtReservationPrice.isDisplayed();
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public Boolean getElementsDisplayed() {
        return elementsDisplayed;
    }

    public void setElementsDisplayed(Boolean elementsDisplayed) {
        this.elementsDisplayed = elementsDisplayed;
    }
}
