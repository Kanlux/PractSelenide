import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.Condition.*;

@Epic("Авторизация пользователя")
@Owner("Sergey")
public class SignIn extends ParentTest {
    @RegisterExtension
    static SoftAssertsExtension softAssert = new SoftAssertsExtension();

    AuthorizationPage authorization = new AuthorizationPage();
    UserPage user = new UserPage();

    @Description("Успешный вход в систему")
    @Test
    public void signInPos() {
        authorization.SignInPos();

        user.img().shouldBe(appear);
    }

    @Description("Неуспешный вход в систему")
    @Test
    public void signInNeg() {
        authorization.searchEmail().setValue(DataUser.invalidemail);
        authorization.searchPassword().setValue(DataUser.password);
        authorization.button().click();

        authorization.errorEmail().shouldBe(visible);
    }
}
