import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repository}")

    public void searchForRepository(String repository){
        $("[name='q']").setValue("eroshenkoam/allure-example").pressEnter();
    }
    @Step("Переходим в репозиторий")

    public void goToRepository(String repository){
        $("[href=\"/eroshenkoam/allure-example\"]").click();
    }
    @Step("Открываем таб Issues в репозитории")
    public void openIssueTab(){
        $(withText("Issues")).click();
    }
    @Step("Проверяем, что Issue с номером {number} существует ")

    public void shouldSeeIssueWithNumber(int number){
        $(withText("68")).should(Condition.exist);
    }

}
