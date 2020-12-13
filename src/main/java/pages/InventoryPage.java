package pages;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

public class InventoryPage {


    public ProductPage selectItem(String product) {
        $(new Selectors.ByText(product)).click();
        return new ProductPage();
    }


}
