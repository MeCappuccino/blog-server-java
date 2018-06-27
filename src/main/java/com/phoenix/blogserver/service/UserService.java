package com.phoenix.blogserver.service;

import com.phoenix.blogserver.common.ResponseMessage;
import com.phoenix.blogserver.entity.User;

public interface UserService {

    ResponseMessage login(String name, String password);

    ResponseMessage changePasswd(User user);
}
