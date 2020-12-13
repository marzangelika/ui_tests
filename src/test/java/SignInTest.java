import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SignInTest extends BaseTest {


    @Test
    public void successfulSignInTest() {
        open(baseUrl);

        signInPage.signIn(userName, password);
        String expectedUrl = inventoryPageUrl;

        Assert.assertEquals(expectedUrl, url());
    }

    @Test
    public void incorrectDetailsErrorMessageTest() {
        open(baseUrl);

        signInPage.setUserName(incorrectUserName).setPassword(password).submit();
        String expectedIncorrectDetailsErrorMessage = "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(signInPage.getErrorMessageText(), expectedIncorrectDetailsErrorMessage);
    }

    @Test
    public void requiredPasswordErrorMessageTest() {
        open(baseUrl);

        signInPage.setUserName(userName).submit();

        String expectedRequiredPasswordErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(expectedRequiredPasswordErrorMessage, signInPage.getErrorMessageText());
    }

    @Test
    public void requiredUserNameErrorMessageTest() {
        open(baseUrl);

        signInPage.setPassword(password).submit();

        String expectedRequiredUserNameErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(expectedRequiredUserNameErrorMessage, signInPage.getErrorMessageText());
    }

    @Test
    public void lockedOutUserErrorMessageTest() {
        open(baseUrl);

        signInPage.signIn(lockedOutUserName, password);

        String expectedLockedOutUserErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(expectedLockedOutUserErrorMessage, signInPage.getErrorMessageText());

    }

}
