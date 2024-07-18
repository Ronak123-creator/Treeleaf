package com.task.BlogWeb.controller;


import com.task.BlogWeb.model.BlogPost;
import com.task.BlogWeb.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//
//@RestController
//@RequestMapping("/api/blogs")
//public class BlogController {
//    @Autowired
//    private BlogPostService blogPostService;
//
//    @PostMapping
//    public BlogPost addBlogPost(@RequestBody BlogPost blogPost) {
//        return blogPostService.addBlogPost(blogPost);
//    }
//
//    @GetMapping
//    public List<BlogPost> getAllBlogPosts() {
//        return blogPostService.getAllBlogPosts();
//    }
//
//    @GetMapping("/{id}")
//    public BlogPost getBlogPostById(@PathVariable Long id) {
//        return blogPostService.getBlogPostById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteBlogPost(@PathVariable Long id) {
//        blogPostService.deleteBlogPost(id);
//    }
//}


@RestController
@RequestMapping("/api/blogposts")
class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<?> addBlogPost(@RequestBody BlogPost blogPost) {
        try {
            BlogPost newBlogPost = blogPostService.addBlogPost(blogPost);
            return ResponseEntity.ok(newBlogPost);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding blog post");
        }
    }

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogPostById(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.getBlogPostById(id);
        if (blogPost == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blogPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlogPost(@PathVariable Long id) {
        try {
            blogPostService.deleteBlogPost(id);
            return ResponseEntity.ok("Blog post deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting blog post");
        }
    }
}
