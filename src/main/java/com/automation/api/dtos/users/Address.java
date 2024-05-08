package com.automation.api.dtos.users;

import lombok.Data;

/** DTO class for address. */
@Data
public class Address {

  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private Geo geo;
}
