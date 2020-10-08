package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class ConfigurarPrivacidadScreen extends BaseScreen {

    /**
     * Constructor method for standard screen object.
     *
     * @param pDriver
     */
    public ConfigurarPrivacidadScreen(AndroidDriver<AndroidElement> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(id = "com.trivago:id/action_settings")
    private AndroidElement btnConfiguracion;

    @AndroidFindBy(id = "com.trivago:id/fragmentSettingsManageMyDataTextView")
    private AndroidElement btnConfigurarPrivacidad;

    @AndroidFindBy(id = "com.trivago:id/activityDataManagerFacebookCheckbox")
    private AndroidElement optFacebook;

    @AndroidFindBy(id = "com.trivago:id/activityDataManagerSaveButton")
    private AndroidElement btnGuardar;

    public ConfigurarPrivacidadScreen configurarPrivacidadScreen() {
        btnConfiguracion.click();
        btnConfigurarPrivacidad.click();
        optFacebook.click();
        btnGuardar.click();
        btnConfigurarPrivacidad.click();
        setOptFacebook(optFacebook);
        return new ConfigurarPrivacidadScreen(driver);
    }

    public AndroidElement getOptFacebook() {
        return optFacebook;
    }

    public void setOptFacebook(AndroidElement optFacebook) {
        this.optFacebook = optFacebook;
    }
}
