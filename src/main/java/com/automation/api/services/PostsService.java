package com.automation.api.services;

import static com.automation.core.Constants.BASE_URI;
import static com.automation.core.Constants.POSTS_URI;
import static com.automation.core.Constants.POST_ID_FIELD;
import static com.automation.core.Constants.POST_ID_PATH;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import com.automation.api.base.BaseService;
import com.automation.api.dtos.posts.Post;
import java.util.List;

/**
 * Post API services.
 */
public class PostsService extends BaseService {

  /**
   * Convert the response to a Post object.
   *
   * @return Post
   */
  @Override
  public Post getResponseAsObject() {
    return response.getBody().as(Post.class);
  }

  @Override
  public List<Post> getResponseAsList() {
    return response.getBody().jsonPath().getList(EMPTY, Post.class);
  }

  /**
   * Endpoint for obtain all posts.
   */
  public void getAllPosts() {
    requestGet(BASE_URI, POSTS_URI);
  }

  /**
   * Endpoint for obtain post by id.
   *
   * @param postId to search by id
   */
  public void getPostById(String postId) {
    requestGetByParam(BASE_URI, POSTS_URI + POST_ID_PATH, POST_ID_FIELD, postId);
  }

  /**
   * Endpoint to create a new post.
   *
   * @param newPost Post that is going to be posted
   */
  public void postNewPost(Post newPost) {
    requestPost(BASE_URI, POSTS_URI, newPost);
  }

  /**
   * Endpoint to delete a post by id.
   *
   * @param postId ID of the post
   */
  public void deletePostById(String postId) {
    requestDeleteByParam(BASE_URI, POSTS_URI + POST_ID_PATH, POST_ID_FIELD, postId);
  }
}
