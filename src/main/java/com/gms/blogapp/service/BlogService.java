package com.gms.blogapp.service;

import com.gms.blogapp.Repository.BlogRepository;
import com.gms.blogapp.Repository.UserRepository;
import com.gms.blogapp.entity.Blog;
import com.gms.blogapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public ResponseEntity<Blog> addBlog(Blog blog) {
        blog.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(blogRepository.save(blog), HttpStatus.OK);
    }
    public ResponseEntity<List<Blog>> getBlogByCategory(String category) {
        return new ResponseEntity<>(blogRepository.findByCategory(category),HttpStatus.OK);
    }

    public ResponseEntity<List<Blog>> showAllBlogs() {
        return new ResponseEntity<>(blogRepository.findAll(),HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity<Blog> editBlog(Long id, Blog blog) {
        Blog b = blogRepository.findById(id).get();
        b.setContent(blog.getContent());
        return new ResponseEntity<>(blogRepository.save(b),HttpStatus.OK);
    }
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> addBookmark(int userId,Long blogId) {
       User user = userRepository.findById(userId).get();
       Blog blog = blogRepository.findById(blogId).get();
       user.setBookmarkedBlogs(List.of(blog));
       userRepository.save(user);
       return new ResponseEntity<>("Added",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteBlog(Long id) {
        blogRepository.deleteById(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
