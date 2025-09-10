import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class ParentTest {

    FirstPage first = new FirstPage();
    AuthorizationPage authorization = new AuthorizationPage();

    @BeforeEach
    public void sign() {
        open("https://news-feed.dunice-testing.com/");
        first.entrance().click();
    }
}
