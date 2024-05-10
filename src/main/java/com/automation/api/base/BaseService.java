package com.automation.api.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

import static com.automation.core.Constants.BASE_URI;
import static com.automation.core.Constants.USERS_URI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import io.restassured.response.Response;
import java.util.Map;
import lombok.Getter;


/** Class to model the Base service. */
@Getter
public abstract class BaseService implements ApiService {

  protected Response response;

  @Override
  public int getStatusCode() {
    return response.getStatusCode();
  }

  /**
   * This is a function to create a Get request.
   *
   * @param baseUri base uri of the request
   * @param path path in which the request is going to be made
   */
  protected void requestGet(String baseUri, String path) {
    response =
        given()
            .filter(new AllureRestAssured())
            .baseUri(baseUri)
            .contentType(JSON)
            .when()
            .get(path);
  }

  /**
   * This is a function to create a new element using rest assured.
   *
   * @param baseUri base uri of the request
   * @param path path in which the request is going to be made
   * @param body model object
   * @return Response
   */
  protected void requestPost(String baseUri, String path, Object body) {
    response = RestAssured.given()
        .baseUri(baseUri)
        .contentType(JSON)
        .body(body)
        .when()
        .post(path);
  }
}
