package io.github.rusponomar;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubIssueTest {
  private final static String REPOSITORY = "ruslanPonomarev/wearebrain-testing-automation";
  private final static String USER = "ruslanPonomarev";
  private final static int ISSUE_NUMBER = 1;

  @Test
  public void searchForIssue(){
    final Map<String, Object> data = new HashMap<>();

    step("Open main page", () -> {
      open("https://github.com");
    });
    step("Find repo" + REPOSITORY, () -> {
      $(".header-search-input").click();
      $(".header-search-input").sendKeys(REPOSITORY);
      $(".header-search-input").submit();
    });
    step("Go to Repository" + REPOSITORY, () -> {
      data.put("something", 2);
      $(By.linkText(REPOSITORY)).click();
    });
    step("Go to issues list", () ->{
      $(withText("Isses")).click();
    });
    step("Check existing of Issue with number" + ISSUE_NUMBER, () -> {
      System.out.println(data.get("something"));
      $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    });
  }
}
