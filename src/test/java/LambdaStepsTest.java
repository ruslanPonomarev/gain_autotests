//package io.github.rusponomar;
//
//import com.codeborne.selenide.Condition;
//import io.qameta.allure.Allure;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.codeborne.selenide.Selectors.withText;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//import static io.qameta.allure.Allure.step;
//
//public class LambdaStepsTest {
//  private final static String REPOSITORY = "ruslanPonomarev/wearebrain-testing-automation";
//  private final static String USER = "ruslanPonomarev";
//  private final static int ISSUE_NUMBER = 1;
//
//  @Test
//  public void searchForIssue() {
////    if (USER.equalsIgnoreCase("ruslanPonomarev")) {
////      Allure.feature("Issues");
////    } else {
////      Allure.feature("Milestones");
////    }
//
//    Allure.feature("Issues");
//    Allure.story("Issues testing story");
//
//    step("Open main page", () -> {
//      final String url = "https://github.com";
//      open(url);
//      Allure.link("Testing", url);
//    });
//    step("Find repo" + REPOSITORY, (step) -> {
//      step.parameter("name", REPOSITORY);
//
//      $(".header-search-input").click();
//      $(".header-search-input").sendKeys(REPOSITORY);
//      $(".header-search-input").submit();
//    });
//    step("Go to Repository" + REPOSITORY, (step) -> {
//      step.parameter("name", REPOSITORY);
//
//      $(By.linkText(REPOSITORY)).click();
//    });
//    step("Go to issues list", () ->{
//      $(withText("Issues")).click();
//    });
//    step("Check existing of Issue with number" + ISSUE_NUMBER, (step) -> {
//      step.parameter("number", REPOSITORY);
//
//      $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
//    });
//  }
//}
