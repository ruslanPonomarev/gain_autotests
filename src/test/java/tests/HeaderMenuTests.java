package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Header menu")
public class HeaderMenuTests extends TestBase{

  @Test
  @DisplayName("Header has clickable and visible menu links and logo image")
  void headerNavMenuTest() {
    // Arrange
    step("Open main page", () -> open(""));
    step("Check that all nav links displays", () -> {
      $$("#menu-top-menu").shouldHave(texts("Themes Get started Submit case study About us"));
    });

    // Assert
    step("Brand logo image have correct URL addresses ", () -> {
      $(".header-brand__link").shouldHave(href("https://gain.stg.thebrain4web.com/en/"));
    });
    step("Nav menu links have correct URL addresses", () -> {
      $("#menu-item-189").find(By.linkText("Themes")).shouldHave(href("https://gain.stg.thebrain4web.com/en/themes/")).shouldBe(visible);
      $("#menu-item-826").find(By.linkText("Get started")).shouldHave(href("https://gain.stg.thebrain4web.com/en/get-started/")).shouldBe(visible);
      $("#menu-item-188").find(By.linkText("Submit case study")).shouldHave(href("https://gain.stg.thebrain4web.com/en/submit-case-study/")).shouldBe(visible);
      $("#menu-item-190").find(By.linkText("About us")).shouldHave(href("https://gain.stg.thebrain4web.com/en/about-us/")).shouldBe(visible);
    });
  }

  @Test
  @DisplayName("Displays search input field  with submit button")
  void SearchInputIsDisplays(){
    step("Open main page", () -> open(""));
    step("Check that search input field and submit button displays ", () -> {
    $(".search-field").shouldHave(type("search"));
    $(".search-submit").shouldHave(type("submit"));
    });
  }
}
