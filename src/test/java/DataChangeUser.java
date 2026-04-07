import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.File;

import static com.codeborne.selenide.Condition.text;

@Epic("Изменение данных пользователя")
@Owner("Sergey")
public class DataChangeUser extends ParentTest {
    @RegisterExtension
    static SoftAssertsExtension softAssert = new SoftAssertsExtension();

    AuthorizationPage authorization = new AuthorizationPage();
    UserPage user = new UserPage();

    @Description("Успешное изменение данных пользователя")
    @Test
    public void changePos() {
        authorization.SignInPos();

        user.img().click();
        user.dataChange().click();
        user.dataLogin().setValue("Kanlux");
        user.dataEmail().setValue(DataUser.email);
        user.dataFile().uploadFile(new File("src/test/Img/Ava.jpeg"));
        user.change().click();

        user.examination().shouldHave(text("Привет, Kanlux!"));
    }

    @Description("Неуспешное изменение данных пользователя")
    @Test void changeNeg() {
        authorization.SignInPos();

        user.img().click();
        user.dataChange().click();
        user.dataLogin().setValue("Володя");
        user.dataEmail().setValue(DataUser.invalidemail);
        user.dataFile().uploadFile(new File("src/test/Img/Ava.jpeg"));
    }
}
