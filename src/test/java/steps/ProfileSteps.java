package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProfilePage;

import static org.testng.AssertJUnit.assertTrue;

public class ProfileSteps {
    private ProfilePage profilePage;
    private HomePage homePage;

    public ProfileSteps(ProfilePage profilePage, HomePage homePage) {
        this.profilePage = profilePage;
        this.homePage = homePage;
    }
    @Given("User is on profile page")
    public void userIsOnProfilePage() {
        profilePage.goToProfilePage();
    }

    @And("user opens the form")
    public void userOpensTheForm() {
        profilePage.openRegistrationForm();
    }

    @And("user choose to connect")
    public void userChooseToConnect() {
        profilePage.openLoginForm();
    }

    @When("user fills the form with {string} {string}")
    public void userFillsTheFormWith(String phoneNumber, String password) {
        profilePage.fillLoginForm(phoneNumber, password);
    }

    @And("submit the form")
    public void submitTheForm() {
        profilePage.submitForm();
    }

    @Then("user is redirected to home page")
    public void userIsRedirectedToHomePage() {
        assertTrue(homePage.isHomePage());
    }

    @And("user backs on profile page")
    public void userBacksOnProfilePage() {
        profilePage.goToProfilePage();
    }

    @And("user sees his code")
    public void seeHisCode() {
        assertTrue(profilePage.isCode());
    }
}
