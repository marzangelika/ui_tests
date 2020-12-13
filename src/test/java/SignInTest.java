import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SignInTest {
    SignInPage signInPage = new SignInPage();

    String userName = System.getenv("SAUCE_USERNAME");
    String incorrectUserName = "test";
    String lockedOutUserName = "locked_out_user";
    String password = System.getenv("SAUCE_PASSWORD");
    String baseUrl = System.getenv("SAUCE_URL");
    String inventoryPageUrl = baseUrl + "/inventory.html";

    @BeforeMethod
    public void openSignInPageUrl() {
        open(baseUrl);
    }

    @Test
    public void successfulSignInTest() {
        signInPage.signIn(userName, password);
        String expectedUrl = inventoryPageUrl;

        Assert.assertEquals(expectedUrl, url());
    }

    @Test
    public void incorrectDetailsErrorMessageTest() {
        signInPage.setUserName(incorrectUserName).setPassword(password).submit();
        String expectedIncorrectDetailsErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(signInPage.getErrorMessageText(), expectedIncorrectDetailsErrorMessage);
    }

    @Test
    public void requiredPasswordErrorMessageTest() {
        signInPage.setUserName(userName).submit();

        String expectedRequiredPasswordErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(expectedRequiredPasswordErrorMessage, signInPage.getErrorMessageText());
    }

    @Test
    public void requiredUserNameErrorMessageTest() {
        signInPage.setPassword(password).submit();

        String expectedRequiredUserNameErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(expectedRequiredUserNameErrorMessage, signInPage.getErrorMessageText());
    }

    @Test
    public void lockedOutUserErrorMessageTest() {
        signInPage.signIn(lockedOutUserName, password);

        String expectedLockedOutUserErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(expectedLockedOutUserErrorMessage, signInPage.getErrorMessageText());
    }

}
