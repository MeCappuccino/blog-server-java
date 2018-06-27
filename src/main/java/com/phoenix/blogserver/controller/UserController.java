package com.phoenix.blogserver.controller;

import com.phoenix.blogserver.common.ResponseMessage;
import com.phoenix.blogserver.entity.User;
import com.phoenix.blogserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @ResponseBody
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResponseMessage login(String name,String password){
        return userServiceImpl.login(name, password);
    }

    @ResponseBody
    @RequestMapping(value="/changePasswd",method = RequestMethod.POST)
    public ResponseMessage changePasswd(User user){
        return userServiceImpl.changePasswd(user);
    }

}
