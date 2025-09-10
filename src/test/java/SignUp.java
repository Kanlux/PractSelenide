import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SignUp {
    @RegisterExtension
    static SoftAssertsExtension softAssert = new SoftAssertsExtension();

    FirstPage first = new FirstPage();
    AuthorizationPage authorization = new AuthorizationPage();
    RegistrationPage registration = new RegistrationPage();

    @BeforeEach
    public void sign() {
        open("https://news-feed.dunice-testing.com/");
        first.entrance().click();
        authorization.searchRegistration().click();
    }

    @Test
    public void signUpPos() {
        registration.signUpPos();

        RegistrationPage registrationPage = mock(RegistrationPage.class);
        SelenideElement mockElement = mock(SelenideElement.class);
        when(registrationPage.searchError()).thenReturn(mockElement);

        registration.searchError().shouldBe(visible);
    }

    @Test
    public void signUpNeg() {
        registration.signUpNeg();

        registration.errorEmail().shouldBe(visible);
    }
}
