import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsLambda {
    //2. Лямбда шаги через step (name, () -> {})
    private static final String BASE_URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void testIssueSearch(){

        step("Открываем главную страницу", () -> {
            open(BASE_URL);
        });

        step("Ищем репозиторий", () -> {
            $("[name='q']").setValue(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий", () -> {
            $("[href=\"/eroshenkoam/allure-example\"]").click();
        });

        step("Открываем таб Issues в репозитории", () -> {
            $(withText("Issues")).click();
        });

        step("Проверяем, что Issue с номером 68 существует", () -> {
            $(withText(String.valueOf(ISSUE_NUMBER))).should(Condition.visible);
        });
    }

}
