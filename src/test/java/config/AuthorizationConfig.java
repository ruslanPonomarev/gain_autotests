package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "classpath:config/authorization.properties"
})

public interface AuthorizationConfig extends Config {
  @Config.Key("username")
  String editorUsername();

  @Config.Key("password")
  String editorPassword();

}
