package io.github.rusponomar.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {
  public static void configureDriver() {
    Configuration.baseUrl = "https://wearebrain:9UT38CeKTYiYggG7@gain.stg.thebrain4web.com";
  }

  public static String getConsoleLogs() {
    return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
  }
}
