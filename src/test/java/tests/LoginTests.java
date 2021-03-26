package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Condition.*;
import config.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase {

//  @Test
//  void selenideSearchItem() {
//    String searchItem = ConfigHelper.getSearchItem();
//    String searchResult = ConfigHelper.getSearchResult();
//    open("https://google.com");
//    $(byName("q")).setValue(searchItem).pressEnter();
//    $("html").shouldHave(Condition.text(searchResult));
//  }

  @Test
  @DisplayName("Successful login in CMS as an Editor")
  void loginAsEditor() {
    // Arrange
    step("Open main page", () -> open("/wp/wp-login.php"));
    //    open("https://wearebrain:9UT38CeKTYiYggG7@gain.stg.thebrain4web.com/wp/wp-login.php");
    // Act
    step("Fill auth form", () -> {
        $("#user_login").sendKeys(ConfigHelper.getEditorUsername());
        $("#user_pass").sendKeys(ConfigHelper.getEditorPassword());
        $("#wp-submit").click();
      });

    // Assert
    step("Verify successfully authorization an Editor", () -> {
      $("#wpbody-content h1").shouldHave(Condition.text("Dashboard"));
    });
  }
}
