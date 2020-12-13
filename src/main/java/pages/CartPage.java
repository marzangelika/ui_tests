package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    SelenideElement cartItem = $(new Selectors.ByText("Sauce Labs Backpack"));

    public SelenideElement getCartItem() {
        return cartItem;
    }
}
