package org.cs;

import org.cs.blog.dao.BlogDao;
import org.cs.blog.entity.Blog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright © 2018 pagoda Inc.
 * Description:
 *
 * @author wangjunjun
 * @date 2018/12/1
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-context.xml");
        Object o = context.getBean("firstBean");
        System.out.println(o.getClass());
        BlogDao blogDao = (BlogDao) context.getBean("blogDao");
        Map<String,String> condition = new HashMap<>();
        condition.put("id","1");
        Blog blog = blogDao.selectByCondiction(condition);
        System.out.println(blog.getName());
    }

}
