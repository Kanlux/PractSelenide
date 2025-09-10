import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UserPage {

    public SelenideElement img() {
        return $("#profile-icon__avatar");
    }
}
