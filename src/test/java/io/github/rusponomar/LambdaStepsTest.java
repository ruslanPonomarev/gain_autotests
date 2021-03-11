package io.github.rusponomar;

import com.codeborne.selenide.Condition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GitHubIssueTest {
  private final static String REPOSITORY = "ruslanPonomarev/wearebrain-testing-automation";
  private final static String USER = "ruslanPonomarev";
  private final static int ISSUE_NUMBER = 1;

//  private WebDriver driver;

//  @BeforeEach
//  public void initDriver() {
//    driver = new WebDriverProvider().get();
//  }

  @Test
  public void searchForIssue(){
    step("Open main page", () -> {
      open("https://github.com");
    });
    step("Find repo" + REPOSITORY, () -> {
      $(".header-search-input").click();
      $(".header-search-input").sendKeys(REPOSITORY);
      $(".header-search-input").submit();
    });
    step("Go to Repository" + REPOSITORY, () -> {
      $(By.linkText(REPOSITORY)).click();
    });
    step("Go to issues list", () ->{
      $(withText("Isses")).click();
    });
    step("Check existing of Issue with number" + ISSUE_NUMBER, () -> {
      $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    });
  }

//  @Test
//  public void testMainPage(){
//    final ServiceConfig config = ConfigFactory.newInstance()
//      .create(ServiceConfig.class);
//    driver.get(config.baseURL());
//  }

//  @AfterEach
//  public void stopDriver() {
//    driver.quit();
//  }
}
