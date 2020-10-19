package com.automation.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectDate extends BasePage {

    private WebDriver driver;
    WebDriverWait wait;

    public SelectDate(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[data-bui-ref='calendar-date']")
    private List<WebElement> listDates;

    @FindBy(css = "[data-placeholder='Fecha de salida']")
    private WebElement btnCalendar;

    @FindBy(css = "[data-bui-ref='calendar-next']")
    private WebElement btnNext;

    @FindBy(css = ".-submit-button [data-sb-id='main']")
    private WebElement btnSearch;

    public SelectHotel checkInAndCheckOut() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNext));
        checkIin(listDates);
        btnCalendar.click();
        checkOut(listDates);
        btnSearch.click();
        return new SelectHotel(driver);
    }

    private void checkIin(List<WebElement> dates) {
        Boolean today = false;
        int days = 0;
        int dateEmpty = 0;
        for (WebElement date : dates) {
            if (date.getAttribute("class").equals("bui-calendar__date bui-calendar__date--today")) today = true;
            if (today) days++;
            if (date.getAttribute("class").equals("bui-calendar__date bui-calendar__date--empty")) days--;
            if (days > 29) {
                date.click();
                break;
            }
        }
    }

    private void checkOut(List<WebElement> dates) {
        Boolean initialDate = false;
        int days = 0;
        for (WebElement date : dates) {
            if (date.getAttribute("class").equals("bui-calendar__date bui-calendar__date--selected")) initialDate = true;
            if (initialDate) days++;
            if (date.getAttribute("class").equals("bui-calendar__date bui-calendar__date--empty")) days--;
            if (days > 14) {
                date.click();
                break;
            }
        }
    }
}
