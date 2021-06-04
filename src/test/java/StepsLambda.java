import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsLambda {
    //2. Лямбда шаги через step (name, () -> {})
    @Test
    public void testIssueSearch(){
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий", () -> {
            $("[name='q']").setValue("eroshenkoam/allure-example").pressEnter();
        });
        step("Переходим в репозиторий", () -> {
            $("[href=\"/eroshenkoam/allure-example\"]").click();
        });
        step("Открываем таб Issues в репозитории", () -> {
            $(withText("Issues")).click();
        });
        step("Проверяем, что Issue с номером 68 существует", () -> {
            $(withText("68")).should(Condition.exist);
        });
    }

}
