package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class SelectTheLanguageScreen extends BaseScreen {

    private static final String FIRST_LOCATOR = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\"Colombia\"))";
    private static final String SECOND_LOCATOR = "new UiSelector().className(\"android.widget.TextView\")" +
            ".textContains(\"Confirm\")";

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver
     */
    public SelectTheLanguageScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(uiAutomator = FIRST_LOCATOR)
    private AndroidElement optionCol;

    @AndroidFindBy(uiAutomator = SECOND_LOCATOR)
    private AndroidElement btnConfirm;

    @AndroidFindBy(id = "com.trivago:id/activityCookieConsentContentTitleTextView")
    private AndroidElement txtPrivacidadDeDatos;

    public PrivacidadDeDatosScreen selectColombia() {
        optionCol.click();
        btnConfirm.click();
        customWait.waitAndroidElementToBeClickable(driver, txtPrivacidadDeDatos, 10);
        setTxtPrivacidadDeDatos(txtPrivacidadDeDatos);
        return new PrivacidadDeDatosScreen(driver);
    }

    public AndroidElement getTxtPrivacidadDeDatos() {
        return txtPrivacidadDeDatos;
    }

    public void setTxtPrivacidadDeDatos(AndroidElement txtPrivacidadDeDatos) {
        this.txtPrivacidadDeDatos = txtPrivacidadDeDatos;
    }
}
