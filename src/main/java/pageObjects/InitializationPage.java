package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class InitializationPage extends Page {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement authorizeButton;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement authorizeToGetPosition;
    @AndroidFindBy(id = "com.kikuu:id/tv_skip")
    private MobileElement skipAuthenticationForm;
    @AndroidFindBy(id = "com.kikuu:id/country_txt")
    private List<MobileElement> countries;

    public void authorizeCall() {
        click(authorizeButton);
    }

    public void authorizeMediaAccess() {
        click(authorizeButton);
    }

    public void skipAuthenticationScreen() {
        click(skipAuthenticationForm);
    }

    public void chooseCountry(String country) {
        click(countries.stream()
                .filter(countryElement -> country.contains(countryElement.getText()))
                .collect(Collectors.toList())
                .get(0));
    }

    public void authorizeToGetPosition() {
        click(authorizeToGetPosition);
    }


}
