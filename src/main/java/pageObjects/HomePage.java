package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page{

    @AndroidFindBy( id= "com.kikuu:id/hot_keys_flipper")
    private MobileElement searchBar;
    @AndroidFindBy( id= "com.kikuu:id/search_input_et")
    private MobileElement searchBarInput;
    @AndroidFindBy( id= "com.kikuu:id/product_name_txt")
    private List<MobileElement> searchedProductsName;
    @AndroidFindBy( id= "com.kikuu:id/navi_search_layout")
    private MobileElement validateSearch;
    @AndroidFindBy(id = "com.kikuu:id/banner_home")
    private MobileElement bannerHome;
    @AndroidFindBy(id = "com.kikuu:id/title_txt")
    private List<MobileElement> productsTitle;
    @AndroidFindBy(id = "com.kikuu:id/no_data_hint_img")
    private MobileElement noResultsImg;

    public void clickOnSearchBar(){
        click(searchBar);
    }

    public boolean isHomePage() {
        return waitForVisibility(bannerHome);
    }

    public void getSearchBar() {
        click(searchBar);
    }

    public void searchProduct(String searchText) {
        searchBarInput.sendKeys(searchText);
    }

    public void validateSearch() {
        click(validateSearch);
    }

    public boolean searchResults(String searchText) {
        List<MobileElement> list = searchedProductsName.stream()
                .filter(product -> product.getText().contains(searchText))
                .collect(Collectors.toList());

        return list.size() == searchedProductsName.size();
    }

    public boolean searchSuggestions(String searchText) {
        List<MobileElement> list = productsTitle.stream()
                .filter(product -> {
                    System.out.println(product.getText());
                    return product.getText().contains(searchText);
                })
                .collect(Collectors.toList());

        return list.size() == productsTitle.size();
    }

    public boolean isNoResultImg() {
        return shortWaitUntil(visibilityOf(noResultsImg));
    }

}
