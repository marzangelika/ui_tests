import pages.CartPage;
import pages.InventoryPage;
import pages.SignInPage;

public class BaseTest {

    SignInPage signInPage = new SignInPage();
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();

    String baseUrl = System.getenv("SAUCE_URL");
    String inventoryPageUrl = baseUrl + "/inventory.html";
    String userName = System.getenv("SAUCE_USERNAME");
    String incorrectUserName = "test";
    String lockedOutUserName = "locked_out_user";
    String password = System.getenv("SAUCE_PASSWORD");
    String product = "Sauce Labs Backpack";
}
