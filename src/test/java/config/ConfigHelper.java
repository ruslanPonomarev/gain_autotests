package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
  public static String getSearchItem() {
    return getWebConfig().searchItem();
  }

  public static String getSearchResult() {
    return getWebConfig().searchResult();
  }

  public static String getEditorUsername() {
    return getAuthorizationConfig().editorUsername();
  }

  public static String getEditorPassword() {
    return getAuthorizationConfig().editorPassword();
  }

  public static String getWebUrl() {
    return getWebConfig().webUrl();
  }

  public static String getWebRemoteDriver() {
    //https://%s:%s@${SELENOID_URL}wd/hub/
    return String.format(System.getProperty("web.remote.driver"),
      getWebConfig().webRemoteDriverUser(),
        getWebConfig().webRemoteDriverPassword());
  }

  public static boolean isRemoteWebDriver() {
    return System.getProperty("web.remote.driver") !=null;
  }

  public static String getWebVideoStorage() {
    return System.getProperty("video.storage");
  }
  public static boolean isVideoOn() {
    return getWebVideoStorage() != null;
  }



  private static AuthorizationConfig getAuthorizationConfig() {
    return ConfigFactory.newInstance().create(
      AuthorizationConfig.class, System.getProperties());
  }

  private static WebConfig getWebConfig() {
    return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
  }

//  public static void setRemoteWebDriver(boolean remoteWebDriver) {
//    ConfigHelper.remoteWebDriver = remoteWebDriver;
//  }
}
