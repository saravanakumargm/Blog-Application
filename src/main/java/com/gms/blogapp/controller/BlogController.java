package com.gms.blogapp.controller;

import com.gms.blogapp.entity.Blog;
import com.gms.blogapp.entity.Comment;
import com.gms.blogapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BlogController {
    @Autowired
    private BlogService blogService;
    @PostMapping("/add-blog")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
        return blogService.addBlog(blog);
    }
    @GetMapping("show-all")
    public ResponseEntity<List<Blog>> showAllBlogs(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        return blogService.showAllBlogs();
    }
    @GetMapping("/category")
    @CrossOrigin
    public ResponseEntity<List<Blog>> getBlogByCategory(@RequestParam(defaultValue = "null") String category){
        return blogService.getBlogByCategory(category);
    }
    @PostMapping("/edit")
    public ResponseEntity<Blog> editBlog(@RequestParam Long id,@RequestBody Blog blog){
        return blogService.editBlog(id,blog);
    }

    @PostMapping("/bookmark")
    public ResponseEntity<String> addBookmark(@RequestParam int userId,@RequestParam Long blogId){
        return blogService.addBookmark(userId,blogId);
    }

    @PostMapping("delete")
    public ResponseEntity<String> deleteBlog(@RequestParam Long id){
        return blogService.deleteBlog(id);
    }

}
