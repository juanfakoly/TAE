package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;
import util.tests.BaseMobileTest;

public class TrivagoTest extends BaseMobileTest {

    @Test(priority = 1)
    public void selectLanguage() {
        SelectTheLanguageScreen selectTheLanguageScreen = selectTheLanguageScreen();
        PrivacidadDeDatosScreen privacidadDeDatosScreen = selectTheLanguageScreen.selectColombia();
        Assert.assertTrue(selectTheLanguageScreen.getTxtPrivacidadDeDatos().isDisplayed());
        privacidadDeDatosScreen.acceptDataPrivacy();
        Assert.assertTrue(privacidadDeDatosScreen.getIsDisplayed());
    }

    @Test(priority = 2)
    public void buscarHotel() {
        BuscarHotelesScreen buscarHotelesScreen = new BuscarHotelesScreen(getDriver());
        buscarHotelesScreen.buscarHotelesScreen();
        Assert.assertTrue(buscarHotelesScreen.getIsDisplayed());

    }

    @Test(priority = 3)
    public void verifyElements() {
        HotelListScreen hotelListScreen = new HotelListScreen(getDriver());
        Assert.assertTrue(hotelListScreen.verifyElements());
    }

    @Test(priority = 4)
    public void configurarPrivacidad() {
        ConfigurarPrivacidadScreen configurarPrivacidadScreen = new ConfigurarPrivacidadScreen(getDriver());
        configurarPrivacidadScreen.configurarPrivacidadScreen();
        Assert.assertFalse(configurarPrivacidadScreen.getIsSelected());
    }
}

