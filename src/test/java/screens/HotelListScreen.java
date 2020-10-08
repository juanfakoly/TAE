package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class HotelListScreen extends BaseScreen {

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver
     */
    public HotelListScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(id = "com.trivago:id/action_home")
    private AndroidElement btnBusqueda;

    @AndroidFindBy(id = "com.trivago:id/action_explore")
    private AndroidElement btnSorprendete;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Favoritos\")")
    private AndroidElement btnFavoritos;

    @AndroidFindBy(id = "com.trivago:id/action_settings")
    private AndroidElement btnConfiguracion;

    public Boolean verifyElements() {
        return btnBusqueda.isDisplayed() && btnSorprendete.isDisplayed()
                && btnFavoritos.isDisplayed() && btnConfiguracion.isDisplayed() ;
    }
}
