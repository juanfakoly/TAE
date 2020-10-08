package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.CustomWait;
import util.screens.BaseScreen;

public class BuscarHotelesScreen extends BaseScreen {

    private CustomWait customWait = new CustomWait();
    private static final String FIRST_LOCATOR = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Cartagena\")";
    private static final String SECOND_LOCATOR = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"noviembre\")" +
            ".fromParent(new UiSelector().childSelector(new UiSelector().className(\"android.view.ViewGroup\")" +
            ".childSelector(new UiSelector().className(\"android.widget.FrameLayout\").childSelector(new UiSelector()" +
            ".className(\"android.widget.TextView\").text(\"1\"))))))";
    private static final String THIRD_LOCATOR = "new UiSelector().className(\"android.widget.TextView\")" +
            ".textContains(\"noviembre\").fromParent(new UiSelector().childSelector(new UiSelector()" +
            ".className(\"android.view.ViewGroup\").childSelector(new UiSelector().className(\"android.widget.FrameLayout\")" +
            ".childSelector(new UiSelector().className(\"android.widget.TextView\").text(\"5\")))))";
    private static final String FOURTH_LOCATOR = "new UiSelector().resourceId(\"com.trivago:id/fragmentHotelSearchResultsRecyclerView\")" +
            ".childSelector(new UiSelector().resourceId(\"com.trivago:id/hotelItemCardView\"))";

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver
     */
    public BuscarHotelesScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(id = "android:id/button3")
    private AndroidElement btnUbicacion;

    @AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformDestinationTextView")
    private AndroidElement txtDestino;

    @AndroidFindBy(id = "com.trivago:id/activitySearchDestinationSearchEditText")
    private AndroidElement txtSearchDestination;

    @AndroidFindBy(uiAutomator = FIRST_LOCATOR)
    private AndroidElement optResultadoBusquedad;

    @AndroidFindBy(uiAutomator = SECOND_LOCATOR)
    private AndroidElement optFecha1;

    @AndroidFindBy(uiAutomator = THIRD_LOCATOR)
    private AndroidElement optFecha2;

    @AndroidFindBy(id = "com.trivago:id/activityDatesSelectionCalendarApplyTextView")
    private AndroidElement btnConfirmarFechas;

    @AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformSearchTextView")
    private AndroidElement btnBuscarHoteles;

    @AndroidFindBy(uiAutomator = FOURTH_LOCATOR)
    private AndroidElement tarjetaHotel;

    public BuscarHotelesScreen buscarHotelesScreen() {
        customWait.waitAndroidElementToBeClickable(driver, btnUbicacion, 10);
        btnUbicacion.click();
        customWait.waitAndroidElementToBeClickable(driver, txtDestino, 10);
        txtDestino.click();
        customWait.waitAndroidElementToBeClickable(driver, txtSearchDestination , 10);
        txtSearchDestination.sendKeys("Cartagena");
        optResultadoBusquedad.click();
        optFecha1.click();
        optFecha2.click();
        btnConfirmarFechas.click();
        customWait.waitAndroidElementToBeClickable(driver, tarjetaHotel, 10);
        setTarjetaHotel(tarjetaHotel);
        return new BuscarHotelesScreen(driver);
    }

    public AndroidElement getTarjetaHotel() {
        return tarjetaHotel;
    }

    public void setTarjetaHotel(AndroidElement tarjetaHotel) {
        this.tarjetaHotel = tarjetaHotel;
    }
}
