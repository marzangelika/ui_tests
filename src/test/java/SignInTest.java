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

}
