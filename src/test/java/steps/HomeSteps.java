package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

import static org.testng.AssertJUnit.assertTrue;

public class HomeSteps {

    private HomePage homePage;

    public HomeSteps(HomePage homePage) {
        this.homePage = homePage;
    }
    @Given("User is on search bar")
    public void userIsOnSearchBar() {
        homePage.getSearchBar();
    }

    @When("User enter a {string} in search bar")
    public void userEnterAInSearchBar(String searchText) {
        homePage.searchProduct(searchText);
    }

    @And("User validate his choice")
    public void userValidateHisChoice() {
        homePage.validateSearch();
    }

    @Then("User should see products that contain {string}")
    public void userShouldSeeProductsThatContain(String searchText) {
        assertTrue(homePage.searchResults(searchText));
    }

    @Then("User should see suggestions appear for {string}")
    public void userShouldSeeSuggestionsAppear(String searchText) {
        assertTrue(homePage.searchSuggestions(searchText));
    }

    @Then("User should see message about no result found")
    public void userShouldSeeMessageAboutNoResultFound() {
        assertTrue(homePage.isNoResultImg());
    }
}
