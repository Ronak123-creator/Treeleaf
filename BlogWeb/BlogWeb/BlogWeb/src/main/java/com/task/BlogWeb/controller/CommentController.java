package com.task.BlogWeb.controller;


import com.task.BlogWeb.model.Comment;
import com.task.BlogWeb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/api/comments")
//public class CommentController {
//    @Autowired
//    private CommentService commentService;
//
//    @PostMapping
//    public Comment addComment(@RequestBody Comment comment) {
//        return commentService.addComment(comment);
//    }
//
//}
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        try {
            Comment newComment = commentService.addComment(comment);
            return ResponseEntity.ok(newComment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding comment");
        }
    }
}
