package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CategoryPage;

import static org.testng.AssertJUnit.assertTrue;

public class CategorySteps {

    private final CategoryPage categoryPage;

    public CategorySteps(CategoryPage categoryPage) {
        this.categoryPage = categoryPage;
    }
    @Given("User is on category page")
    public void userIsOnCategoryPage() {
        categoryPage.getCategoryPage();
    }

    @When("User is on selected {string}")
    public void userIsOnSelected(String category) {
        categoryPage.selectCategory(category);
    }

    @Then("User should see {string}")
    public void userShouldSee(String arg0) {
        assertTrue(categoryPage.isSubCategory(arg0));
    }
}
