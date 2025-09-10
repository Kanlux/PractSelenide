import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@Epic("Удаление новости")
@Owner("Sergey")
public class DeleteNews extends ParentTest {
    @RegisterExtension
    static SoftAssertsExtension softAssert = new SoftAssertsExtension();

    AuthorizationPage authorization = new AuthorizationPage();
    UserPage user = new UserPage();

    @BeforeEach
    void create() {
        authorization.SignInPos();

        user.img().click();
        user.news().click();
        user.createNews();
        user.searchHome().click();
    }

    @Description("Успешное удаление новости")
    @Test
    void deleteNews() {
        user.deleteNews().click();
    }
}
