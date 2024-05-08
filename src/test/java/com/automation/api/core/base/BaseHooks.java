package com.automation.api.core.base;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/** Base hooks class. */
@Slf4j
public class BaseHooks {

  @BeforeSuite
  public void beforeSuite() {
    log.info("Before suite");
  }

  /** Before method hook for initiate the driver. */
  @BeforeMethod
  public void beforeMethod() {
    log.info("Before method");
  }

  @AfterMethod
  public void afterMethod() {
    log.info("After method");
  }
}
