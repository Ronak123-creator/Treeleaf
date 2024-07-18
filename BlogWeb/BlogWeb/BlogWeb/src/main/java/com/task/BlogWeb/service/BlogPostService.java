package com.task.BlogWeb.service;


import com.task.BlogWeb.model.BlogPost;
import com.task.BlogWeb.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost addBlogPost(BlogPost blogPost) {

        return blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {

        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostById(Long id) {

        return blogPostRepository.findById(id).orElse(null);
    }

    public void deleteBlogPost(Long id) {

        blogPostRepository.deleteById(id);
    }

}
