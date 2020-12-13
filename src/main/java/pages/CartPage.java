package pages;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public SelenideElement getCartItem(String product) {
        return $(new Selectors.ByText(product));
    }
}
