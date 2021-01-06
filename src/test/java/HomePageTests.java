import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePageTests {

  @Test
  void selenideSearchTest() {
    // Open home page in browser
    open("https://brain.stg.thebrain4web.com");

    // Enter Selenide in search field
    $(byName("q")).setValue("Selenide").pressEnter();

    // Check that Selenide displays in search results
    $("html").shouldHave(Condition.text("selenide.org"));
    //Let's define a more precise scope for the assertion:
    $("#rcnt").shouldHave(Condition.text("selenide.org"));
  }
}
