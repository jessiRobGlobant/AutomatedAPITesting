package com.automation.api.core.posts;

import com.automation.api.core.base.BaseTest;
import com.automation.api.services.PostsService;
import org.testng.annotations.BeforeMethod;

public class PostsBaseTest extends BaseTest {

  protected PostsService postsService;

  @BeforeMethod
  public void beforeMethod() {
    postsService = new PostsService();
  }

  protected void getPostById(String postId) {
    postsService.getPostById(postId);
  }

}
