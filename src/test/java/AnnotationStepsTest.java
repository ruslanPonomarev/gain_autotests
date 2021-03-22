//package io.github.rusponomar;
//
//import com.codeborne.selenide.Condition;
//import io.qameta.allure.*;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.codeborne.selenide.Selectors.withText;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//import static io.qameta.allure.Allure.step;
//
//public class AnnotationStepsTest {
//  private final static String REPOSITORY = "ruslanPonomarev/wearebrain-testing-automation";
//  private final static String USER = "ruslanPonomarev";
//  private final static int ISSUE_NUMBER = 1;
//
//  @Test
//  @DisplayName("Search for issues")
//  @Feature("Issues")
//  @Story("User should see issues in existing repository")
//  @Link(url = "https://github.com", name ="testing")
//  @Owner("rusponomar")
//  @Severity(SeverityLevel.CRITICAL)
//  public void searchForIssue() {
//    final BaseSteps steps = new BaseSteps();
//
//    steps.openMainPage();
//    steps.searchForRepository(REPOSITORY);
//    steps.goToRepository(REPOSITORY);
//    steps.goToIssues();
//    steps.shoouldSeeIssueWithNumber(ISSUE_NUMBER);
//  }
//
//  public static class BaseSteps {
//
//      @Step("Open main page")
//      public void openMainPage() {
//        open("https://github.com");
//      }
//
//      @Step("Find repo ${name}")
//      public void searchForRepository(final String name) {
//        $(".header-search-input").click();
//        $(".header-search-input").sendKeys(name);
//        $(".header-search-input").submit();
//      }
//
//      @Step("Go to Repository")
//      public void goToRepository(final String name) {
//        $(By.linkText(name)).click();
//      }
//
//      @Step("Go to issues list")
//      public void goToIssues() {
//        $(withText("Issues")).click();
//      }
//
//      @Step("Check existing of Issue with number ${number}")
//      public void shoouldSeeIssueWithNumber(final int number) {
//        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
//      }
//  }
//}
