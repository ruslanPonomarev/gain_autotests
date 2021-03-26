package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("InitiativeBlockTests tests")
public class InitiativeBlockTests extends TestBase{
  @Test
  @DisplayName("Check initiatives block visible and display logo images")
  void initiativesBlockTest(){
    // Arrange
    step("Open main page", () -> open(""));

    // Assert
    step("Title is correct", () -> {
      $("h2.initiatives__title").shouldHave(text("Food Action Cities is an initiative of:"));
    });
    step("Row has 3 logos", () -> {
      $$(".initiatives__row div").shouldHave(size(3));
    });
    step("Check logos are displayed", () -> {
      $(".initiatives__image").shouldBe(visible);
    });
  }
}
