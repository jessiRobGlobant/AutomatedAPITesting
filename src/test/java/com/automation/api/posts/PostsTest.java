package com.automation.api.posts;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalToObject;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import com.automation.api.core.posts.PostsBaseTest;
import com.automation.api.dtos.posts.Post;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class PostsTest extends PostsBaseTest {

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate getting all posts")
  public void validateGetAllPosts() {
    postsService.getAllPosts();

    checkThat.hardAssert("Status code is 200 OK", postsService.getStatusCode(),
        is(SC_OK));
    checkThat.softAssert("List of posts", postsService.getResponseAsList(), hasItems());
  }

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate getting post by id")
  public void validateGetPostById() {
    postsService.getPostById("2");

    checkThat.hardAssert("Status code is 200 OK", postsService.getStatusCode(),
        is(SC_OK));
    checkThat.softAssert("Post information", postsService.getResponseAsObject(),
        notNullValue());
  }

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate posting a new post")
  public void validatePostPost() {
    Post newPost = Post.builder()
        .id(1)
        .title("new post")
        .body("body of a new post")
        .build();
    postsService.postNewPost(newPost);

    checkThat.hardAssert("Status code is 201 OK", postsService.getStatusCode(),
        is(SC_CREATED));
    checkThat.softAssert("Post information", postsService.getResponseAsObject(),
        notNullValue());
    checkThat.softAssert("Post data includes the details of the created post",
        postsService.getResponseAsObject(), equalToObject(newPost));
  }

  @Test
  @Severity(CRITICAL)
  @Story("")
  @TmsLink("")
  @Description("Validate deleting post by id")
  public void validateDeletePostById() {
    String id = "2";
    // Validate id 2 exists
    getPostById(id);
    checkThat.hardAssert(format("Id %s exists", id), postsService.getStatusCode(),
        is(SC_OK));

    // Tests
    postsService.deletePostById(id);

    checkThat.hardAssert("Status code is 200 OK", postsService.getStatusCode(),
        is(SC_OK));
    checkThat.softAssert("Post information", postsService.getResponseAsObject(),
        notNullValue());

    getPostById(id);
    checkThat.softAssert("Post was deleted from system", postsService.getStatusCode(),
        is(SC_NOT_FOUND));
  }

  @Test
  @Severity(CRITICAL)
  @Story("")
  @TmsLink("")
  @Description("Validate patching post by id")
  public void validatePatchPostById() {
    String id = "2";
    // Validate id 2 exists
    getPostById(id);
    checkThat.hardAssert(format("Id %s exists", id), postsService.getStatusCode(),
        is(SC_OK));
    Post post = postsService.getResponseAsObject();

    // Tests
    postsService.patchPostById(id, "{\"title\": \"new title\"}");
    post.setTitle("new title");

    checkThat.hardAssert("Status code is 200 OK", postsService.getStatusCode(),
        is(SC_OK));
    checkThat.softAssert("Post information", postsService.getResponseAsObject(),
        notNullValue());
    checkThat.softAssert("Post data includes the details of the patched post",
        postsService.getResponseAsObject(), equalToObject(post));

  }

  @Test
  @Severity(CRITICAL)
  @Story("")
  @TmsLink("")
  @Description("Validate get not existent post by id")
  public void validateNonExistentGetPostById() {
    String id = "300";

    // Tests
    postsService.getPostById(id);

    checkThat.hardAssert("Status code is 404 OK", postsService.getStatusCode(),
        is(SC_NOT_FOUND));
    checkThat.softAssert("Post information", postsService.getResponseAsObject(),
        nullValue());
  }
}
