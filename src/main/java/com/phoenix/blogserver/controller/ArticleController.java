package com.phoenix.blogserver.controller;

import com.phoenix.blogserver.common.ResponseMessage;
import com.phoenix.blogserver.entity.Article;
import com.phoenix.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ResponseMessage getArticle(String id) {
        return articleService.getArticleById(id);
    }

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.GET)
    public ResponseMessage saveArticle(Article article) {
        return articleService.saveArticle(article);
    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ResponseMessage updateArticle(Article article) {
        return articleService.updateArticle(article);
    }

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ResponseMessage deleteArticle(String id) {
        return articleService.deleteArticle(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
