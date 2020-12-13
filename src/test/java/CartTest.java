import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CartTest extends BaseTest {


    @Test
    public void addToCartTest() {
        open(inventoryPageUrl);
        inventoryPage.selectItem(product).addItemToCart().viewTheCart();

        boolean isItemInTheCart = cartPage.getCartItem(product).isDisplayed();

        Assert.assertTrue(isItemInTheCart);
    }

}
