package io.github.rusponomar.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
  public static String getEditorUsername() {
    return getAuthorizationConfig().editorUsername();
  }

  public static String getEditorPassword() {
    return getAuthorizationConfig().editorPassword();
  }

  private static AuthorizationConfig getAuthorizationConfig() {
    return ConfigFactory.newInstance().create(AuthorizationConfig.class, System.getProperties());
  }
}
