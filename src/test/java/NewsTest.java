import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Epic("Создание новости")
@Owner("Sergey")
public class NewsTest extends ParentTest {
    @RegisterExtension
    static SoftAssertsExtension softAssert = new SoftAssertsExtension();

    AuthorizationPage authorization = new AuthorizationPage();
    UserPage user = new UserPage();

    @BeforeEach
    void news() {
        authorization.SignInPos();

        user.img().click();
        user.news().click();
    }

    @Description("Успешное создание")
    @Test
    public void newsPos() {
        user.title().setValue("Hello");
        user.text().setValue("sss");
        user.tags().setValue("Serj");
        user.fileNews().uploadFile(new File("src/test/Img/Ava.jpeg"));
        user.addNews().click();

        user.examinationNews().shouldHave(text("Hello"));
    }

    @Description("Неуспешное создание")
    @Test
    public void newsNeg() {
        user.title().setValue("Hello");
        user.text().setValue("ss");
        user.tags().setValue("Serj");
        user.fileNews().uploadFile(new File("src/test/Img/Ava.jpeg"));
        user.addNews().click();

        user.errorNews().shouldBe(visible);
    }
}
