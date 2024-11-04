package com.gms.blogapp.service;

import com.gms.blogapp.Repository.BlogRepository;
import com.gms.blogapp.Repository.CommentRepository;
import com.gms.blogapp.entity.Blog;
import com.gms.blogapp.entity.Comment;
import com.gms.blogapp.entity.UserPrincipal;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BlogRepository blogRepository;

    public ResponseEntity<String> addComment(Long id, Comment comment) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        Blog blog = blogRepository.findById(id).get();
        comment.setBlog(blog);
        blog.setComments(List.of(comment));
        comment.setUserName(user);
        comment.setTimestamp(LocalDateTime.now());
        commentRepository.save(comment);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteComment(Long id) {
        if(commentRepository.findById(id).isEmpty()){
            return new ResponseEntity<>("Comment does not exist!",HttpStatus.BAD_REQUEST);
        }
        commentRepository.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    public ResponseEntity<Comment> editComment(Long id, Comment comment) {
        Comment c = commentRepository.findById(id).get();
        if(commentRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(comment,HttpStatus.BAD_REQUEST);
        }
        c.setComment(comment.getComment());
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
    }
}
