package com.gms.blogapp.Repository;

import com.gms.blogapp.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
    public List<Blog> findByCategory(String category);
}
