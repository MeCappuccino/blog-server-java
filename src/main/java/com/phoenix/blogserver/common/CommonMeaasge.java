package com.phoenix.blogserver.common;

public interface CommonMeaasge {
    int OK = 200;
    int FAIL = 500;
    String FIND_OK = "查询成功";
    String FIND_FAIL = "查询失败";
    String LOGIN_OK = "登陆成功";
    String LOGIN_FAIL = "用户名或密码错误";
    String CHANGE_PWD_OK = "密码变更成功";
    String CHANGE_PWD_FAIL = "密码变更失败";
    String SAVE_ARTICLE_OK = "文章保存成功";
    String SAVE_ARTICLE_FAIL = "文章保存失败";
    String DELETE_ARTICLE_OK = "删除文章成功";
    String DELETE_ARTICLE_FAIL = "删除文章失败";
}
