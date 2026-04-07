import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;

@Epic("Удаление пользователя")
@Owner("Sergey")
public class DeleteUser extends ParentTest{
    @RegisterExtension
    static SoftAssertsExtension softAssert = new SoftAssertsExtension();

    UserPage user = new UserPage();
    FirstPage first = new FirstPage();
    RegistrationPage registration = new RegistrationPage();

    @Description("Успешное удаление пользователя")
    @Test
    public void delete() {
        authorization.searchRegistration().click();

        registration.signUpPos();

        user.img().click();
        user.deleteUser().click();
        switchTo().alert().accept();

        first.entrance().shouldBe(visible);
    }
}
