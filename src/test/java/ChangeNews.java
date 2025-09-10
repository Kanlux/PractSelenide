import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;

@Epic("Изменение новости")
@Owner("Sergey")
public class ChangeNews extends ParentTest{
    @RegisterExtension
    static SoftAssertsExtension softAssert = new SoftAssertsExtension();

    AuthorizationPage authorization = new AuthorizationPage();
    UserPage user = new UserPage();
    News news = new News();

    @BeforeEach
    void newsPage() {
        authorization.SignInPos();

        user.img().click();
        user.news().click();
        user.createNews();
    }

    @Description("Успешное изменение новости")
    @Test
    public void changeNewsPos() {
        user.updateNews().click();

        news.changeTitle().setValue("Bye");
        news.changeText().setValue("www");
        news.changeTags().setValue("Serjik");
        news.changeFile().uploadFile(new File("src/test/Img/Ava.jpeg"));
        news.changeNews().click();

        user.examinationNews().shouldHave(text("Bye"));
    }

    @Description("Неуспешное изменение новости")
    @Test
    public void changeNewsNeg() {
        user.updateNews().click();

        news.changeTitle().setValue("Bye");
        news.changeText().setValue("ww");
        news.changeTags().setValue("Serjik");
        news.changeFile().uploadFile(new File("src/test/Img/Ava.jpeg"));
        news.changeNews().click();

        switchTo().alert().accept();
    }
}
