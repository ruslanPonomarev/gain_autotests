package io.github.rusponomar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class MainPageTest extends TestBase {
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

  @Test
  @DisplayName("Page should change language")
  void changeLanguageTest(){
    $("header .brand").click();
  }
}
