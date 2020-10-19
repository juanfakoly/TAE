package com.automation.booking.pages;

import com.automation.booking.utils.SwitchWindow;
import com.automation.booking.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmReservation extends BasePage{

    private WebDriver driver;
    private WebDriverWait wait;
    private String reservation;

    public ConfirmReservation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "#group_recommendation .bui-price-display__label")
    private WebElement txtReservation;

    @FindBy(css = "#group_recommendation .bui-button")
    private WebElement btnReservationOfRooms;

    @FindBy(css = "#hprt-table tbody tr:first-child td:nth-child(5) select option[value='1']")
    private WebElement btnRoomsNumber;

    @FindBy(css = ".hprt-container .bui-button")
    private WebElement btnConfirmReservation;

    public FillForm rooms() {
        SwitchWindow.switchWindow(driver);
        setReservation(txtReservation.getText());
        btnReservationOfRooms.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnRoomsNumber));
        btnRoomsNumber.click();
        btnConfirmReservation.click();
        return new FillForm(driver);
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }
}
