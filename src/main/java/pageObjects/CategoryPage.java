package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryPage extends Page{

    @AndroidFindBy(id = "com.kikuu:id/tab_shop_img")
    private MobileElement categoryButton;
    @AndroidFindBy(id = "com.kikuu:id/category_name_txt")
    private List<MobileElement> categoriesNames;
    @AndroidFindBy(id = "com.kikuu:id/category_name_txt")
    private List<MobileElement> subCategoryList;

    public void getCategoryPage() {
        click(categoryButton);
    }

    public void selectCategory(String categorySearch) {
        click(categoriesNames.stream()
                .filter(category -> category.getText().contains(categorySearch))
                .collect(Collectors.toList())
                .get(0)
        );
    }

    public boolean isSubCategory(String subCategoryName) {
        return (int) subCategoryList.stream()
                .filter(subCategory -> subCategory.getText().contains(subCategoryName))
                .count() > 0;
    }
}
