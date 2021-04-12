package tests;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.link;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Short Case Study")
public class ShortCaseStudyTests extends TestBase{

  @BeforeEach
  public void openCaseStudyPage(){
    step("Open case studies list", () -> open("/en/case-studies/arusha-edible-gardens/"));
    step("display category", () -> {
      $(".section__category").shouldHave(text("Case study"));
    });

  }

  @Test
  @DisplayName("Check title\"Arusha Edible Gardens\" Case study")
  void checkTitle(){
    step("Open case studies list", () -> $("h1").shouldHave(exactText("Arusha Edible Gardens")));
  }

  @Test
  @DisplayName("Check tags are display")
  void checkTags() {
    step("Tags list should have size 9 items (6 plus 3 Partners)", () ->
            $$("ul.taxonomy-list__nav a")).shouldHave(CollectionCondition.size(9));
  }

  @Test
  @DisplayName("Citation block is display")
  void checkCitationBlockIsDisplay() {
    step("Check Citation Title", () -> {
      $(".citation__title").shouldHave(exactText("Citation"));
    });
    step("Check Citation Content", () -> {
      $(".citation__body p").shouldHave(exactText("This case study version is from the Menu of Actions (2019). Suggested citation: Halliday, J., Platenkamp, L., Nicolarea, Y. (2019) A menu of actions to shape urban food systems for improved nutrition, GAIN, MUFPP and RUAF."));
    });
  }

  @Test
  @DisplayName("Check featured image is Display")
  void checkFeaturedImageIsDisplay() {
    step("Check featured image is Display", () -> {
      $(".article-cover__mask>img").shouldBe(image);
    });
  }

  @Test
  @DisplayName("H2 anchors are Display")
  void checkH2AnchorsAreDisplay() {
    step("Check \"When it was introduced\" is Display", () -> {
      $("#when-it-was-introduced").shouldBe(exactText("When it was introduced"));
    });
    step("Check \"Why it was needed\" is Display", () -> {
      $("#why-it-was-needed").shouldBe(exactText("Why it was needed"));
    });
    step("Check \"Who initiated it, who is involved\" is Display", () -> {
      $("#who-initiated-it-who-is-involved").shouldBe(exactText("Who initiated it, who is involved"));
    });
    step("Check \"Impacts to date\" is Display", () -> {
      $("#impacts-to-date").shouldBe(exactText("Impacts to date"));
    });

  }

}
