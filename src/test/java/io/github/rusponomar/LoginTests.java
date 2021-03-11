package io.github.rusponomar;

import com.codeborne.selenide.Condition;
import io.github.rusponomar.config.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase {
  @Test
  @DisplayName("Successful login in CMS as an Editor")
  void loginAsEditor() {
    // Arrange
    open("https://wearebrain:9UT38CeKTYiYggG7@gain.stg.thebrain4web.com/wp/wp-login.php");

    // Act
    $("#user_login").setValue(ConfigHelper.getEditorUsername());
    $("#user_pass").setValue(ConfigHelper.getEditorPassword());
    $("#wp-submit").click();

    // Assert
    $("#wpwrap.wrap h1").shouldHave(Condition.text("Dashboard"));
  }
}
