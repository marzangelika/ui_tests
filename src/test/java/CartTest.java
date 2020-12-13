import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;

import static com.codeborne.selenide.Selenide.open;

public class CartTest {
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    String baseUrl = System.getenv("SAUCE_URL");
    String inventoryPageUrl = baseUrl + "/inventory.html";
    String product = "Sauce Labs Backpack";

    @Test
    public void addToCartTest() {
        open(inventoryPageUrl);
        inventoryPage.selectItem(product).addItemToCart().viewTheCart();

        boolean isItemInTheCart = cartPage.getCartItem(product).isDisplayed();
        Assert.assertTrue(isItemInTheCart);
    }

}
