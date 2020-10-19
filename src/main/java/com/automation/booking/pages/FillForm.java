package com.automation.booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FillForm extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FillForm(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "lastname")
    private WebElement txtLastName;

    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "email_confirm")
    private WebElement txtEmailConfirmation;

    @FindBy(css = "[name='book']")
    private WebElement btnNext;

    @FindBy(css = "#cc1 option[value='co']")
    private WebElement btnCountry;

    @FindBy(id = "phone")
    private WebElement txtPhone;

    @FindBy(css = "#cc_type option[value='Visa']")
    private WebElement btnCreditCardType;

    @FindBy(id = "cc_number")
    private WebElement txtCreditCardNumber;

    @FindBy(css = "#cc_month option[value='10']")
    private WebElement btnExpirationMonth;

    @FindBy(css = "#ccYear option[value='2022']")
    private WebElement btnExpirationYear;

    @FindBy(id = "cc_cvc")
    private WebElement txtCVC;

    public FinalValidation withUserData(String lastName, String email, String phone,
                                        String creditCardNumber, String cvc) {
        wait.until(ExpectedConditions.visibilityOf(txtLastName));
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        txtEmailConfirmation.sendKeys(email);
        btnNext.click();
        btnCountry.click();
        txtPhone.sendKeys(phone);
        btnCreditCardType.click();
        txtCreditCardNumber.sendKeys(creditCardNumber);
        btnExpirationMonth.click();
        btnExpirationYear.click();
        txtCVC.sendKeys(cvc);
        return new FinalValidation(driver);
    }
}
