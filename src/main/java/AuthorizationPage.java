import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {

    public SelenideElement searchEmail() {
        return $("input[type = 'email']");
    }

    public SelenideElement searchPassword() {
        return $("input[type = ''password]");
    }

    public SelenideElement searchRegistration() {
        return $(byText("Регистрация"));
    }
}
