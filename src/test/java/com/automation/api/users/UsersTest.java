package com.automation.api.users;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalToObject;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import com.automation.api.core.users.UsersBaseTest;
import com.automation.api.dtos.users.User;
import com.automation.utils.JsonManager;
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

    checkThat.hardAssert("Status code is 200 OK", usersService.getStatusCode(),
        is(SC_OK));
    checkThat.softAssert("List of users", usersService.getResponseAsList(), hasItems());
  }

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate getting user by id")
  public void validateGetUserById() {
    usersService.getUserById("2");

    checkThat.hardAssert("Status code is 200 OK", usersService.getStatusCode(),
        is(SC_OK));
    checkThat.softAssert("User information", usersService.getResponseAsObject(),
        notNullValue());
  }

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate posting a new user")
  public void validatePostUser() {
    String userJson = """
        {
            "name": "Leanne Grahams",
            "username": "Bret1",
            "email": "Sincere3@april.biz",
            "address": {
              "street": "Kulas Light",
              "suite": "Apt. 556",
              "city": "Gwenborough",
              "zipcode": "92998-3874",
              "geo": {
                "lat": "-37.3159",
                "lng": "81.1496"
              }
            },
            "phone": "1-770-736-8031 x56442",
            "website": "hildegard.org",
            "company": {
              "name": "Romaguera-Crona",
              "catchPhrase": "Multi-layered client-server neural-net",
              "bs": "harness real-time e-markets"
            }
        }
        """;
    User newUser = JsonManager.fromJson(userJson, User.class);
    usersService.postNewUser(newUser);

    checkThat.hardAssert("Status code is 201 OK", usersService.getStatusCode(),
        is(SC_CREATED));
    checkThat.softAssert("User information", usersService.getResponseAsObject(),
        notNullValue());
    checkThat.softAssert("User data includes the details of the created user",
        usersService.getResponseAsObject(), equalToObject(newUser));
  }

  @Test
  @Severity(CRITICAL)
  @Story("")
  @TmsLink("")
  @Description("Validate deleting user by id")
  public void validateDeleteUserById() {
    String id = "2";
    // Validate id 2 exists
    getUserById(id);
    checkThat.hardAssert(format("Id %s exists", id), usersService.getStatusCode(),
        is(SC_OK));

    // Tests
    usersService.deleteUserById(id);

    checkThat.hardAssert("Status code is 200 OK", usersService.getStatusCode(),
        is(SC_OK));
    checkThat.softAssert("User information", usersService.getResponseAsObject(),
        notNullValue());

    getUserById(id);
    checkThat.softAssert("User was deleted from system", usersService.getStatusCode(),
        is(SC_NOT_FOUND));
  }

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate posting a new user with a wrong structure")
  public void validateWrongPostUser() {
    String userJson = """
        {
             "userId": 1,
             "title": "qui est esse",
             "body": "a body"
         }
        """;

    usersService.postNewUser(userJson);

    checkThat.hardAssert("Status code is 400", usersService.getStatusCode(),
        is(SC_BAD_REQUEST));
  }
}
