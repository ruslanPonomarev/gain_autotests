package io.github.rusponomar;

import org.junit.jupiter.api.BeforeAll;
import static io.github.rusponomar.helpers.DriverHelper.configureDriver;

public class TestBase {
  @BeforeAll
  public static void beforeAll() {
    configureDriver();
  }
}
