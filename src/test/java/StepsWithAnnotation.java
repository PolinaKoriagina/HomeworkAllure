import org.junit.jupiter.api.Test;

public class StepsWithAnnotation {
    //            3. Шаги с аннотацией @Step

    private WebSteps steps = new WebSteps();

    @Test
    public void testSearchIssue(){
        steps.openMainPage();
        steps.searchForRepository("eroshenkoam/allure-example");
        steps.goToRepository("eroshenkoam/allure-example" );
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(68);
    }
}
