import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.Condition.visible;
import static org.mockito.Mockito.*;

@Epic("Регистрация пользователя")
@Owner("Sergey")
public class SignUp extends ParentTest {
    @RegisterExtension
    static SoftAssertsExtension softAssert = new SoftAssertsExtension();

    RegistrationPage registration = new RegistrationPage();

    @Description("Успешная регистрация через мок" +
            "Этот тест не создаёт нового пользователя, а проверяет вызов метода" +
            "Для выполнения остальных тестов нужно пройти регистрацию ручным способом" +
            "Все нужные данные для регистрации находяться в DataUser")
    @Test
    public void signUpPos() {
        authorization.searchRegistration().click();

        registration.signUpPos();

        RegistrationPage registrationPage = mock(RegistrationPage.class);
        SelenideElement mockElement = mock(SelenideElement.class);
        when(registrationPage.searchError()).thenReturn(mockElement);

        registration.searchError().shouldBe(visible);
    }

    @Description("Неспешная регистрация")
    @Test
    public void signUpNeg() {
        authorization.searchRegistration().click();

        registration.signUpNeg();

        registration.errorEmail().shouldBe(visible);
    }
}
