package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@Tag("web")
public class MainPageTests extends TestBase {
  @Test
  @DisplayName("Page should have title\"Latest Posts\"")
  void titlePageTests() {
    open("");

    $("h1").shouldHave(text("Latest Posts"));
  }

  @Test
  @DisplayName("Page blocks should be loaded")
  void baseBlocksLoadedTest(){

    open("");
    $("header h2").shouldHave(text("Hello world!")).shouldBe(visible);

  }

//  @Test
//  @DisplayName("Page should change language")
//  void changeLanguageTest(){
//    $(".header-brand.header-brand__link").click();
//  }

  @Test
  @DisplayName("The console log should not have any errors")
  void consoleLogShouldNotHaveErrors(){
    // Arrange
    open("");

    // Act
    String consoleLogs = getConsoleLogs();

    // Assert
    assertThat(consoleLogs, not(containsString("SEVERE")));
  }
}
