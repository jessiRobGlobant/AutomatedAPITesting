package com.automation.api.users;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

import com.automation.api.core.users.UsersBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class UsersTest extends UsersBaseTest {

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate getting all users")
  public void validateGetAllUsers() {
    usersService.getAllUsers();

    checkThat.hardAssert("Status code is 200 OK", usersService.getStatusCode(), is(SC_OK));
    checkThat.softAssert("List of users", usersService.getResponseAsList(), hasItems());
  }

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate getting user by id")
  public void validateGetUserById() {
    usersService.getUserById("1");

    checkThat.hardAssert("Status code is 200 OK", usersService.getStatusCode(), is(SC_OK));
    checkThat.softAssert("User information", usersService.getResponseAsObject(), notNullValue());
  }
}
