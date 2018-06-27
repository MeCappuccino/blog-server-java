package com.phoenix.blogserver.repository;

import com.phoenix.blogserver.base.BaseRepository;
import com.phoenix.blogserver.entity.User;

public interface UserRepository extends BaseRepository<User, Integer> {

    User findByName(String name);

}

