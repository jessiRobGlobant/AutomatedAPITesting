package com.automation.utils;

import com.google.gson.Gson;

/**
 * Class that manages the Json content and files.
 */
public class JsonManager {

  /**
   * Deserializes a JSON string to a class object.
   *
   * @param json JSON string
   * @param clazz class that is going to be deserialized
   * @return Object from JSON
   */
  public static <T> T fromJson(String json, Class<T> clazz) {
    Gson gson = new Gson();
    return gson.fromJson(json, clazz);
  }


}
