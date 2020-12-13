import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SignInTest {

    SignInPage signInPage = new SignInPage();

    String baseUrl = System.getenv("SAUCE_URL");
    String userName = System.getenv("SAUCE_USERNAME");
    String incorrectUserName = "test";
    String lockedOutUserName = "locked_out_user";
    String password = System.getenv("SAUCE_PASSWORD");

    @Test
    public void successfulSignInTest() {
        open(baseUrl);

        signInPage.signIn(userName, password);
        String expectedUrl = baseUrl + "/inventory.html";

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
