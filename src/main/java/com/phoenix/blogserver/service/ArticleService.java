package com.phoenix.blogserver.service;

import com.phoenix.blogserver.common.ResponseMessage;
import com.phoenix.blogserver.entity.Article;

public interface ArticleService {

     ResponseMessage getArticleById(String id);

     ResponseMessage saveArticle(Article article);

     ResponseMessage updateArticle(Article article);

     ResponseMessage deleteArticle(String id);

}
