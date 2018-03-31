package com.phoenix.blogserver.repository;

import com.phoenix.blogserver.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, String> {
}
