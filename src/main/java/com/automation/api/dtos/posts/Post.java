package com.automation.api.dtos.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for model Post.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

  private int id;
  private int userId;
  private String title;
  private String body;

}
