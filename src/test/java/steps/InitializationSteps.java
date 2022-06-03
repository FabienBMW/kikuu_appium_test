package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.InitializationPage;

import static org.testng.AssertJUnit.assertTrue;

public class InitializationSteps {

    private final InitializationPage initializationPage;
    private final HomePage homePage;

    public InitializationSteps (InitializationPage initializationPage, HomePage homePage) {
        this.homePage = homePage;
        this.initializationPage = initializationPage;
    }

    @Given("user launches the application")
    public void userLaunchesTheApplication() {
    }

    @And("he lets the application to make call")
    public void heLetsTheApplicationToMakeCall() {
        initializationPage.authorizeCall();
    }
    @And("he lets the application to access medias")
    public void heLetsTheApplicationToAccessMedias() {
        initializationPage.authorizeMediaAccess();
    }

    @And("he skip the authentication screen")
    public void heSkipTheAuthenticationScreen() {
        initializationPage.skipAuthenticationScreen();
    }

    @When("user chooses his\\(her) country {string}")
    public void userChoosesHisHerCountry(String country) {
        initializationPage.chooseCountry(country);
    }

    @And("he authorizes the application to get position")
    public void heAuthorizesTheApplicationToGetPosition() {
        initializationPage.authorizeToGetPosition();
    }

    @Then("he should access home page")
    public void heShouldAccessHomePage() {
        assertTrue(homePage.isHomePage());
    }
}
