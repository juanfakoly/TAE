package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.CustomWait;
import util.screens.BaseScreen;

public class PrivacidadDeDatosScreen extends BaseScreen {

    private CustomWait customWait = new CustomWait();

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver
     */
    public PrivacidadDeDatosScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentAcceptButton")
    private AndroidElement btnAceptarTodo;

    @AndroidFindBy(id = "com.trivago:id/fragmentHomeExpandedDealformDestinationTextView")
    private AndroidElement txtDestino;

    public PrivacidadDeDatosScreen acceptDataPrivacy() {
        btnAceptarTodo.click();
        customWait.waitAndroidElementToBeClickable(driver, txtDestino, 10);
        setTxtDestino(txtDestino);
        return new PrivacidadDeDatosScreen(driver);
    }

    public AndroidElement getTxtDestino() {
        return txtDestino;
    }

    public void setTxtDestino(AndroidElement txtDestino) {
        this.txtDestino = txtDestino;
    }
}
