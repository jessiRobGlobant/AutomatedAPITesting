package com.automation.api.base;

import io.restassured.response.Response;
import lombok.Getter;

/** Class to model the Base service. */
@Getter
public abstract class BaseService implements ApiService {

  protected Response response;

  @Override
  public int getStatusCode() {
    return response.getStatusCode();
  }
}
