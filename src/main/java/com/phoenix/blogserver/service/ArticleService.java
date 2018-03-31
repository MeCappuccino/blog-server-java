package com.phoenix.blogserver.service;

import com.phoenix.blogserver.common.CommonMeaasge;
import com.phoenix.blogserver.entity.Article;
import com.phoenix.blogserver.common.ResponseMessage;
import com.phoenix.blogserver.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ResponseMessage getArticleById(String id){
        Article article = articleRepository.findOne(id);
        ResponseMessage message = new ResponseMessage();
        if(article != null){
            message.setStatusCode(CommonMeaasge.OK);
            message.setMessage(CommonMeaasge.FIND_OK);
            message.setData(article);
        }else{
            message.setStatusCode(CommonMeaasge.FAIL);
            message.setMessage(CommonMeaasge.FIND_FAIL);
        }
        return message;
    }

    public ResponseMessage saveArticle(Article article){
        Article ans = articleRepository.save(article);
        ResponseMessage message = new ResponseMessage();
        if(ans != null){
            message.setStatusCode(CommonMeaasge.OK);
            message.setMessage(CommonMeaasge.SAVE_ARTICLE_OK);
        }else{
            message.setStatusCode(CommonMeaasge.FAIL);
            message.setMessage(CommonMeaasge.SAVE_ARTICLE_FAIL);
        }
        message.setData(ans);
        return message;
    }

    public ResponseMessage updateArticle(Article article){
        return saveArticle(article);
    }

    public ResponseMessage deleteArticle(String id){
        Article ans = articleRepository.findOne(id);
        ResponseMessage message = new ResponseMessage();
        if(ans != null) {
            message.setStatusCode(CommonMeaasge.OK);
            message.setMessage(CommonMeaasge.DELETE_ARTICLE_OK);
            articleRepository.delete(id);
        }else{
            message.setStatusCode(CommonMeaasge.FAIL);
            message.setMessage(CommonMeaasge.DELETE_ARTICLE_FAIL);
        }
        return message;
    }

}
