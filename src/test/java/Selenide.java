import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Selenide {
    //    Написать тест на проверку названия Issue в репозитории через Web-интерфейс.
//            1. Чистый Selenide
//       - открыть гитхаб
//       - найти eroshenkoam/allure-example
//       - открыть репозиторий
//       - выбрать issue
//       - проверка, что issue 68 существует


    @Test
    public void testIssueSearch(){
        open("https://github.com");
//        $(".header-search-input").click();
//        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
//        $(".header-search-input").submit();
        $("[name='q']").setValue("eroshenkoam/allure-example").pressEnter();
        $("[href=\"/eroshenkoam/allure-example\"]").click();
        $(withText("Issues")).click();
        $(withText("68")).should(Condition.exist);


    }

}
