import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserPage {

    public SelenideElement img() {
        return $("#profile-icon__avatar");
    }

    public SelenideElement dataChange() {
        return $(byText("Изменить данные"));
    }

    public SelenideElement dataLogin() {
        return $("#mat-form-field-login__input");
    }

    public SelenideElement dataEmail() {
        return $("#mat-form-field-email__input");
    }

    public SelenideElement dataFile() {
        return $("#user-img");
    }

    public SelenideElement examination() {
        return $("#tool-bar__greeting");
    }

    public SelenideElement change() {
        return $(byText("Изменить"));
    }

    public SelenideElement deleteUser() {
        return $(byText("Удалить пользователя"));
    }

    public SelenideElement news() {
        return $(byText("Добавить новый пост"));
    }

    public SelenideElement title() {
        return $("#title-mat-form-field__input");
    }

    public SelenideElement text() {
        return $("#content-mat-form-field__text-area");
    }

    public SelenideElement tags() {
        return $("#tags-mat-form-field__input");
    }

    public SelenideElement fileNews() {
        return $("#news-img");
    }

    public SelenideElement addNews() {
        return $(byText("Добавить"));
    }

    public SelenideElement examinationNews() {
        return $("#news-body-header__title");
    }

    public SelenideElement errorNews() {
        return $("#add-news-form__image-warning");
    }

    public SelenideElement updateNews() {
        return $(byText("Обновить запись"));
    }

    public SelenideElement searchHome() {
        return $("#home-icon__default");
    }

    public SelenideElement searchNews() {
        return $("#mat-form-field__input");
    }

    public SelenideElement search() {
        return $("#news-body-content__text");
    }

    public SelenideElement searchButton() {
        return $(byText("Искать"));
    }

    public SelenideElement matError() {
        return $(byText("Длина строки поиска должна быть не меньше 3 символов"));
    }

    public SelenideElement deleteNews() {
        return $(byText("Удалить запись"));
    }

    public void createNews() {
        title().setValue("Hello");
        text().setValue("sss");
        tags().setValue("Serj");
        fileNews().uploadFile(new File("src/test/Img/Ava.jpeg"));
        addNews().click();
    }
}
