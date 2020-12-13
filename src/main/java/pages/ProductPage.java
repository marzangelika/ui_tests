package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    private SelenideElement cartButton = $(".shopping_cart_container"),
                            addToCartButton = $(".btn_inventory");

    public ProductPage addItemToCart() {
        addToCartButton.click();
        return this;
    }

    public void viewTheCart() {
        cartButton.click();
    }
}


