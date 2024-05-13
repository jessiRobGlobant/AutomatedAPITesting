package com.automation.api.base;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import lombok.Getter;


/**
 * Class to model the Base service.
 */
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
   * @param path    path in which the request is going to be made
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
   * This is a function to get element by a param using rest assured.
   *
   * @param baseUri    base uri of the request
   * @param path       path in which the request is going to be made
   * @param paramField param string in the path
   * @param param      param which is going to be retrieved
   */
  protected void requestGetByParam(String baseUri, String path,
                                   String paramField, String param) {
    response =
        given()
            .filter(new AllureRestAssured())
            .baseUri(baseUri)
            .basePath(path)
            .pathParam(paramField, param)
            .contentType(JSON)
            .when()
            .get();
  }

  /**
   * This is a function to create a new element using rest assured.
   *
   * @param baseUri base uri of the request
   * @param path    path in which the request is going to be made
   * @param body    model object
   */
  protected void requestPost(String baseUri, String path, Object body) {
    response =
        given()
            .filter(new AllureRestAssured())
            .baseUri(baseUri)
            .basePath(path)
            .contentType(JSON)
            .body(body)
            .when()
            .post();
  }

  /**
   * This is a function to delete element by a param using rest assured.
   *
   * @param baseUri    base uri of the request
   * @param path       path in which the request is going to be made
   * @param paramField param string in the path
   * @param param      param which is going to be deleted
   */
  protected void requestDeleteByParam(String baseUri, String path,
                                      String paramField, String param) {
    response =
        given()
            .filter(new AllureRestAssured())
            .baseUri(baseUri)
            .basePath(path)
            .pathParam(paramField, param)
            .contentType(JSON)
            .when()
            .delete();
  }

  /**
   * This is a function to patch an element by a param using rest assured.
   *
   * @param baseUri    base uri of the request
   * @param path       path in which the request is going to be made
   * @param paramField param string in the path
   * @param param      param which is going to be deleted
   * @param body       model object
   */
  protected void requestPatchByParam(String baseUri, String path,
                                     String paramField, String param, String body) {
    response =
        given()
            .filter(new AllureRestAssured())
            .baseUri(baseUri)
            .basePath(path)
            .pathParam(paramField, param)
            .contentType(JSON)
            .body(body)
            .when()
            .patch();
  }
}
