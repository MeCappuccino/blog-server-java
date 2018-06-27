package com.phoenix.blogserver.base.impl;

import com.phoenix.blogserver.base.BaseService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

public class BaseServiceImpl implements BaseService {

    @Autowired
    public EntityManager entityManager;

    //JPA查询工厂
    public JPAQueryFactory queryFactory;

    @PostConstruct
    public void initFactory() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

}
