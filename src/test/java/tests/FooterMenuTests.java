package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Footer menu tests")
public class FooterMenuTests extends TestBase {
  @Test
  @DisplayName("Footer has clickable and visible menu links and logo image")
  void footerNavMenuTest() {
    // Arrange
    step("Open main page", () -> open(""));
    step("Check that all Links are display", () -> {
      $$("#menu-footer-menu").shouldHave(texts("Sitemap Terms and Conditions Privacy Accessibility Contact"));
    });

    // Assert
    step("Brand logo image have correct URL addresses ", () -> {
      $(".footer-brand__link").shouldHave(href("https://gain.stg.thebrain4web.com/en/"));
    });
    step("Nav menu links have correct URL addresses", () -> {
      $("#menu-item-191").find(By.linkText("Sitemap")).shouldBe(visible);
      $("#menu-item-203").find(By.linkText("Terms and Conditions")).shouldHave(href("https://gain.stg.thebrain4web.com/en/terms-and-conditions/")).shouldBe(visible);
      $("#menu-item-202").find(By.linkText("Privacy")).shouldHave(href("https://gain.stg.thebrain4web.com/en/privacy/")).shouldBe(visible);
      $("#menu-item-201").find(By.linkText("Accessibility")).shouldHave(href("https://gain.stg.thebrain4web.com/en/accessibility/")).shouldBe(visible);
      $("#menu-item-200").find(By.linkText("Contact")).shouldHave(href("https://gain.stg.thebrain4web.com/en/contact/")).shouldBe(visible);
    });
  }
}
