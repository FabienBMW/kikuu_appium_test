package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends Page{

    @AndroidFindBy(id = "com.kikuu:id/tab_kikuu_img")
    private MobileElement profileButton;
    @AndroidFindBy(id = "com.kikuu:id/m3_header_login_reg")
    private MobileElement registrationForm;
    @AndroidFindBy(accessibility = "Se connecter")
    private MobileElement connectionForm;
    @AndroidFindBy(id = "com.kikuu:id/et_account")
    private MobileElement phoneField;
    @AndroidFindBy(id = "com.kikuu:id/et_password")
    private MobileElement passwordField;
    @AndroidFindBy(id = "com.kikuu:id/login_submit_btn")
    private MobileElement submitLoginFormButton;
    @AndroidFindBy(id = "com.kikuu:id/m3_header_user_name_txt")
    private MobileElement userCode;

    public void goToProfilePage() {
        if (waitForVisibility(profileButton)) {
            System.out.println("bla");
            click(profileButton);
        }

    }

    public void openRegistrationForm() {
        click(registrationForm);
    }

    public void openLoginForm() {
        click(connectionForm);
    }

    public void fillLoginForm(String phoneNumber, String password) {
        phoneField.sendKeys(phoneNumber);
        passwordField.sendKeys(password);
    }

    public void submitForm() {
        click(submitLoginFormButton);
    }

    public boolean isCode() {
        return waitForVisibility(userCode);
    }
}
