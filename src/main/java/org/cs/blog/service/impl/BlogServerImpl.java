package org.cs.blog.service.impl;

import org.cs.blog.dao.BlogDao;
import org.cs.blog.service.BlogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2018 pagoda Inc.
 * Description:
 *
 * @author wangjunjun
 * @date 2018/12/4
 */
@Service
public class BlogServerImpl implements BlogServer {

    @Autowired
    private BlogDao blogDao;

    @Override
    public String getBlogName(String id) {
        Map<String,String> condition = new HashMap<>();
        condition.put("id",id);
        String blogName = blogDao.selectByCondiction(condition).getName();
        return blogName;
    }
}
