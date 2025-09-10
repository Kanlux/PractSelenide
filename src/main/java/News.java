import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class News {

    public SelenideElement changeTitle() {
        return $("#title-mat-form-field__input");
    }

    public SelenideElement changeText() {
        return $("input[value = 'data.description']");
    }

    public SelenideElement changeTags() {
        return $("input[formcontrolname = 'tags']");
    }

    public SelenideElement changeFile() {
        return $("#news-img-input");
    }

    public SelenideElement changeNews() {
        return $(byText("Изменить"));
    }
}
