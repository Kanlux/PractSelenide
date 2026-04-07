import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FirstPage {

    public SelenideElement entrance() {
        return $(byText("Войти"));
    }
}
