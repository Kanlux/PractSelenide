import com.codeborne.selenide.junit5.SoftAssertsExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Epic("Поиск новостей по критерию")
@Owner("Sergey")
public class SearchNews extends ParentTest {
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

    @Description("Успешный поиск")
    @Test
    public void searchNewsPos(){
        user.searchNews().setValue("sss");
        user.searchButton().click();
        user.search().shouldHave(text("sss"));
    }

    @Description("Неуспешный поиск")
    @Test
    public void searchNewsNeg() {
        user.searchNews().setValue("ss");
        user.searchButton().click();

        user.matError().shouldBe(visible);
    }
}
