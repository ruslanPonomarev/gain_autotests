package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("web")
@Feature("Main page")
public class MainPageTests extends TestBase {

  @Test
  @DisplayName("Display language switcher")
  void changeLanguageTest(){
    step("Open main page", () -> open(""));
    step("Check that language switcher displays", () ->
    $(".navbar-lang").shouldBe(visible));
  }

  @Test
  @DisplayName("The console log should not have any errors")
  void consoleLogShouldNotHaveErrors(){
    // Arrange
    step("Open main page", () -> open(""));
    step("Open console and check SEVERE errors", () -> {
      // Act
    String consoleLogs = getConsoleLogs();
      // Assert
    assertThat(consoleLogs, not(containsString("SEVERE")));
    });
  }
}
