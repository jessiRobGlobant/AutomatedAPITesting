package com.automation.api.dtos.posts;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * DTO for model Post.
 */
@Data
@RequiredArgsConstructor
public class Post {

  private int id;
  private int userId;
  private String title;
  private String body;

}
