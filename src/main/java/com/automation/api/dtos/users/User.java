package com.automation.api.dtos.users;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/** DTO for model User. */
@Data
@RequiredArgsConstructor
public class User {

  private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;
}
