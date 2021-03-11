package io.github.rusponomar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHubTest {

  private WebDriver driver;

  @BeforeEach
  public void initDriver() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Test
  public void testGoogle(){
    driver.get("https://github.com");
  }

  @AfterEach
  public void stopDriver() {
    driver.quit();
  }
}
