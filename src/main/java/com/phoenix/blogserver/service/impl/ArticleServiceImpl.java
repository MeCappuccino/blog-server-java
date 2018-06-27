package com.phoenix.blogserver.service.impl;

import com.phoenix.blogserver.base.impl.BaseServiceImpl;
import com.phoenix.blogserver.common.CommonMeaasge;
import com.phoenix.blogserver.entity.Article;
import com.phoenix.blogserver.common.ResponseMessage;
import com.phoenix.blogserver.entity.QArticle;
import com.phoenix.blogserver.repository.ArticleRepository;
import com.phoenix.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    private QArticle qArticle = QArticle.article;

    //通过文章ID获取文章
    public ResponseMessage getArticleById(String id) {
        ResponseMessage responseMessage = new ResponseMessage();
        Article article = articleRepository.findOne(qArticle.id.eq(id));

        if (article != null) {
            responseMessage.setStatusCode(CommonMeaasge.OK);
            responseMessage.setMessage(CommonMeaasge.FIND_OK);
            responseMessage.setData(article);
        } else {
            responseMessage.setStatusCode(CommonMeaasge.FAIL);
            responseMessage.setMessage(CommonMeaasge.FIND_FAIL);
        }

        return responseMessage;
    }

    public ResponseMessage saveArticle(Article article) {
        Article ans = articleRepository.save(article);
        ResponseMessage message = new ResponseMessage();
        if (ans != null) {
            message.setStatusCode(CommonMeaasge.OK);
            message.setMessage(CommonMeaasge.SAVE_ARTICLE_OK);
        } else {
            message.setStatusCode(CommonMeaasge.FAIL);
            message.setMessage(CommonMeaasge.SAVE_ARTICLE_FAIL);
        }
        message.setData(ans);
        return message;
    }

    public ResponseMessage updateArticle(Article article) {
        return saveArticle(article);
    }

    public ResponseMessage deleteArticle(String id) {
        Article ans = queryFactory.selectFrom(qArticle).where(qArticle.id.eq(id)).fetchOne();
        ResponseMessage message = new ResponseMessage();
        if (ans != null) {
            message.setStatusCode(CommonMeaasge.OK);
            message.setMessage(CommonMeaasge.DELETE_ARTICLE_OK);
            articleRepository.delete(id);
        } else {
            message.setStatusCode(CommonMeaasge.FAIL);
            message.setMessage(CommonMeaasge.DELETE_ARTICLE_FAIL);
        }
        return message;
    }

}
