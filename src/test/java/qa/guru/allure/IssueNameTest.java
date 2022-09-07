package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class IssueNameTest {


    @Test
    @Feature("Issue в репозитории1")
    @Story("Создание Issue1")
    @Owner("juliafoxcat")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя1")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("juliafoxcat/lesson_10_allure");
        $(".header-search-input").submit();
        $(linkText("juliafoxcat/lesson_10_allure")).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text("Test issue name"));
    }

}
