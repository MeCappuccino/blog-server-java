package com.phoenix.blogserver.service.impl;

import com.phoenix.blogserver.base.impl.BaseServiceImpl;
import com.phoenix.blogserver.common.CommonMeaasge;
import com.phoenix.blogserver.common.ResponseMessage;
import com.phoenix.blogserver.entity.QUser;
import com.phoenix.blogserver.entity.User;
import com.phoenix.blogserver.repository.UserRepository;
import com.phoenix.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private QUser qUser = QUser.user;

    public ResponseMessage login(String name, String password) {
        User user = userRepository.findByName(name);
        ResponseMessage message = new ResponseMessage();
        message.setStatusCode(CommonMeaasge.FAIL);
        message.setMessage(CommonMeaasge.LOGIN_FAIL);
        if (user != null && user.getPassword().equals(password)) {
            message.setStatusCode(CommonMeaasge.OK);
            message.setMessage(CommonMeaasge.LOGIN_OK);
        }

        return message;
    }

    public ResponseMessage changePasswd(User user) {
        ResponseMessage message = new ResponseMessage();
        message.setStatusCode(CommonMeaasge.FAIL);
        message.setMessage(CommonMeaasge.CHANGE_PWD_FAIL);
        if (user.getPassword().equals(user.getConfirmPassword())) {
            user.setPassword(user.getNewPassword());
            User res = userRepository.save(user);
            if (res != null) {
                message.setStatusCode(CommonMeaasge.OK);
                message.setMessage(CommonMeaasge.CHANGE_PWD_OK);
            }
        }

        return message;
    }
}
