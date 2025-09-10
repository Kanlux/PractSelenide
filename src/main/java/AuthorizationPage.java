import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {

    public SelenideElement searchEmail() {
        return $("input[type = 'email']");
    }

    public SelenideElement searchPassword() {
        return $("input[type = 'password']");
    }

    public SelenideElement button() {
        return $("#login-form__button");
    }

    public SelenideElement searchRegistration() {
        return $(byText("Регистрация"));
    }

    public SelenideElement errorEmail() {
        return $(byText("Некорректный емейл"));
    }

    public void SignInPos() {
        searchEmail().setValue(DataUser.email);
        searchPassword().setValue(DataUser.password);
        button().click();
    }
}
