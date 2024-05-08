package com.automation.api.core.users;

import com.automation.api.core.base.BaseTest;
import com.automation.api.services.UsersService;
import org.testng.annotations.BeforeMethod;

public class UsersBaseTest extends BaseTest {

  protected UsersService usersService;

  @BeforeMethod
  public void beforeMethod() {
    usersService = new UsersService();
  }
}
