package com.gms.blogapp.controller;

import com.gms.blogapp.entity.Comment;
import com.gms.blogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestParam Long id, @RequestBody Comment comment){
        return commentService.addComment(id,comment);
    }
    @PostMapping("/delete")
    public ResponseEntity<String> deleteComment(@RequestParam Long id){
        return commentService.deleteComment(id);
    }
    @PostMapping("/edit")
    public ResponseEntity<Comment> editComment(@RequestParam Long id,@RequestBody Comment comment){
        return commentService.editComment(id,comment);
    }
}
