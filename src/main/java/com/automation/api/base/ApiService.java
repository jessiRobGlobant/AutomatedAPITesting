package com.automation.api.base;

import java.util.List;

/** Interface to model the api service. */
public interface ApiService {

  <T> T getResponseAsObject();

  <T> List<T> getResponseAsList();

  int getStatusCode();
}
