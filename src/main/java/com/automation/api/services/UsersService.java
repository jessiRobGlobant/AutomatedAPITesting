package com.automation.api.services;

import static com.automation.core.Constants.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import com.automation.api.base.BaseService;
import com.automation.api.dtos.users.User;
import io.qameta.allure.restassured.AllureRestAssured;
import java.util.List;

/** User API services. */
public class UsersService extends BaseService {

  @Override
  public User getResponseAsObject() {
    return response.getBody().as(User.class);
  }

  @Override
  public List<User> getResponseAsList() {
    return response.getBody().jsonPath().getList(EMPTY, User.class);
  }

  /** Endpoint for obtain all users. */
  public void getAllUsers() {
    response =
        given()
            .filter(new AllureRestAssured())
            .baseUri(BASE_URI)
            .contentType(JSON)
            .when()
            .get(USERS_URI);
  }

  /**
   * Endpoint for obtain user by id.
   *
   * @param userId to search by id
   */
  public void getUserById(String userId) {
    response =
        given()
            .filter(new AllureRestAssured())
            .baseUri(BASE_URI)
            .basePath(USERS_URI + USER_ID_PATH)
            .pathParam(USER_ID_FIELD, userId)
            .contentType(JSON)
            .when()
            .get();
  }
}
