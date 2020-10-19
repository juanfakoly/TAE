package com.automation.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Accommodation extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public Accommodation(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[data-visible='accommodation,flights']")
    private WebElement btnAccommodation;

    @FindBy(css = "[aria-label='Reduce el número de Adultos'] + span")
    private WebElement txtAdultsNumber;

    @FindBy(css = "[aria-label='Reduce el número de Adultos']")
    private WebElement btnAdultsDesc;

    @FindBy(css = "[aria-label='Aumenta el número de Adultos']")
    private WebElement btnAdultsAsc;

    @FindBy(css = "[aria-label='Reduce el número de Niños'] + span")
    private WebElement txtChildrenNumber;

    @FindBy(css = "[aria-label='Reduce el número de Niños']")
    private WebElement btnChildrenDesc;

    @FindBy(css = "[aria-label='Aumenta el número de Niños']")
    private WebElement btnChildrenAsc;

    @FindBy(css = "[aria-label='Reduce el número de Habitaciones'] + span")
    private WebElement txtRoomsNumber;

    @FindBy(css = "[aria-label='Reduce el número de Habitaciones']")
    private WebElement btnRoomsDesc;

    @FindBy(css = "[aria-label='Aumenta el número de Habitaciones']")
    private WebElement btnRoomsAsc;

    @FindBy(css = "[name='age']  option[value='9']")
    private WebElement btnChildAge;

    @FindBy(css = ".sb-searchbox__button span:nth-child(1)")
    private WebElement btnSearch;

    public SelectDate peopleAndRooms(int adultNumber, int childrenNumber, int roomsNumber) {
        btnAccommodation.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnAdultsAsc));
        selectAccommodation(adultNumber, txtAdultsNumber, btnAdultsAsc, btnAdultsDesc);
        selectAccommodation(childrenNumber, txtChildrenNumber, btnChildrenAsc, btnChildrenDesc);
        selectAccommodation(roomsNumber, txtRoomsNumber, btnRoomsAsc, btnRoomsDesc);
        btnChildAge.click();
        btnSearch.click();
        return new SelectDate(driver);

    }

    private void selectAccommodation(int number, WebElement txtnumber, WebElement asc, WebElement desc) {
        int numberOnPage = Integer.parseInt(txtnumber.getText());
        while (numberOnPage < number) {
            asc.click();
            break;
        }
        while (numberOnPage > number ) {
            desc.click();
            break;
        }
    }
}
