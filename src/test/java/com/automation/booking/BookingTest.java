package com.automation.booking;

import com.automation.booking.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest{

    @Test(priority = 0)
    @Parameters({"destination", "adultNumber", "childrenNumber", "roomsNumber",
            "lastName", "email", "phoneNumber", "creditCardNumber", "cvc"})
    public void reservation(String destination, int adultNumber, int childrenNumber, int roomsNumber,
                            String lastName, String email, String phoneNumber, String creditCardNumber,
                            String cvc) {
        SelectTab selectTab = getSelectTab();
        SearchFor searchFor = selectTab.stay();
        Accommodation accommodation = searchFor.destination(destination);
        SelectDate selectDate = accommodation.peopleAndRooms(adultNumber, childrenNumber, roomsNumber);
        SelectHotel selectHotel = selectDate.checkInAndCheckOut();
        ConfirmReservation confirmReservation = selectHotel.andRooms();
        Assert.assertTrue(selectHotel.getElementsDisplayed());
        FillForm fillForm = confirmReservation.rooms();
        Assert.assertEquals(selectHotel.getReservation(),confirmReservation.getReservation());
        FinalValidation finalValidation = fillForm.withUserData(lastName, email, phoneNumber,
                creditCardNumber, cvc);
        finalValidation.success();
        Assert.assertTrue(finalValidation.getElementsDisplayed());
    }

}
