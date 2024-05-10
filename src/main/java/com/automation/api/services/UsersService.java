package com.automation.api.services;

import static com.automation.core.Constants.BASE_URI;
import static com.automation.core.Constants.USERS_URI;
import static com.automation.core.Constants.USER_ID_FIELD;
import static com.automation.core.Constants.USER_ID_PATH;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import com.automation.api.base.BaseService;
import com.automation.api.dtos.users.User;
import java.util.List;

/**
 * User API services.
 */
public class UsersService extends BaseService {

  /**
   * Convert the response to a User object.
   *
   * @return User
   */
  @Override
  public User getResponseAsObject() {
    return response.getBody().as(User.class);
  }

  @Override
  public List<User> getResponseAsList() {
    return response.getBody().jsonPath().getList(EMPTY, User.class);
  }

  /**
   * Endpoint for obtain all users.
   */
  public void getAllUsers() {
    requestGet(BASE_URI, USERS_URI);
  }

  /**
   * Endpoint for obtain user by id.
   *
   * @param userId to search by id
   */
  public void getUserById(String userId) {
    requestGetByParam(BASE_URI, USERS_URI + USER_ID_PATH, USER_ID_FIELD, userId);
  }

  /**
   * Endpoint to create a new user.
   *
   * @param newUser User that is going to be posted
   */
  public void postNewUser(User newUser) {
    requestPost(BASE_URI, USERS_URI, newUser);
  }

  /**
   * Endpoint to delete a user by id.
   *
   * @param userId ID of the user
   */
  public void deleteUserById(String userId) {
    requestDeleteByParam(BASE_URI, USERS_URI + USER_ID_PATH, USER_ID_FIELD, userId);
  }
}
