package com.phoenix.blogserver.controller;

import com.phoenix.blogserver.common.ResponseMessage;
import com.phoenix.blogserver.entity.Article;
import com.phoenix.blogserver.service.ArticleService;
import com.phoenix.blogserver.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleServiceImpl;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ResponseMessage getArticle(String id) {
        return articleServiceImpl.getArticleById(id);
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseMessage saveArticle(Article article) {
        return articleServiceImpl.saveArticle(article);
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ResponseMessage updateArticle(Article article) {
        return articleServiceImpl.updateArticle(article);
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ResponseMessage deleteArticle(HttpServletRequest req, String id) {
        req.getSession().getAttributeNames();
        return articleServiceImpl.deleteArticle(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
