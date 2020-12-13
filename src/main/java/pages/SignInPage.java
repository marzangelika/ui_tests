package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private SelenideElement userNameInput = $("#user-name"),
                            passwordInput = $("#password"),
                            loginButton = $("#login-button"),
                            errorMessage = $("[data-test='error']");

    public SignInPage setUserName(String userName) {
        userNameInput.setValue(userName);
        return this;
    }

    public SignInPage setPassword(String password) {
        passwordInput.setValue(password);
       return this;
    }

    public void signIn(String username, String password) {
        setUserName(username);
        setPassword(password);
        submit();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void submit() {
        loginButton.click();
    }
}
