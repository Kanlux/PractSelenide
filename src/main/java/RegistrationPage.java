import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public SelenideElement searchLogin() {
        return $("input[type = 'text']");
    }

    public SelenideElement searchEmail() {
        return $("input[type = 'email']");
    }

    public SelenideElement searchPassword() {
        return $("input[type = 'password']");
    }

    public SelenideElement searchFile() {
        return $("input[type = 'file']");
    }

    public SelenideElement buttonRegistration() {
        return $(byText("Регистрация"));
    }

    public SelenideElement searchError() {
        return $(byText("Данная почта занята"));
    }

    public SelenideElement errorEmail() {
        return $(byText("Некорректный емейл"));
    }

    public void signUpPos() {
        searchLogin().setValue(DataUser.login);
        searchEmail().setValue(DataUser.email);
        searchPassword().setValue(DataUser.password);
        searchFile().uploadFile(new File("src/test/Img/Ava.jpeg"));
        buttonRegistration().click();
    }

    public void signUpNeg() {
        searchLogin().setValue("Kanlux");
        searchEmail().setValue(DataUser.invalidemail);
        searchPassword().setValue("sdf27287");
        searchFile().uploadFile(new File("src/test/Img/Ava.jpeg"));
        buttonRegistration().click();
    }
}
