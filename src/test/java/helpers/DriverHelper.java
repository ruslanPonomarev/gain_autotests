package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ConfigHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {
  public static void configureDriver() {
    addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
//    Configuration.browser = System.getProperty("browser", "chrome");

    Configuration.baseUrl = "https://wearebrain:9UT38CeKTYiYggG7@gain.stg.thebrain4web.com";//ConfigHelper.getWebUrl();
    Configuration.startMaximized = true;
    Configuration.timeout = 10000;

    if (ConfigHelper.isRemoteWebDriver()) {
      addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
      // config for Java + Selenide
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("enableVNC", true);
      capabilities.setCapability("enableVideo", true);
      Configuration.browserCapabilities = capabilities;
      Configuration.remote = ConfigHelper.getWebRemoteDriver();
    }
  }

  public static String getSessionId() {
    return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
  }

  public static String getConsoleLogs() {
    return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
  }
}
