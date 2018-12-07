package org.cs.blog.controller;

import org.apache.ibatis.annotations.Param;
import org.cs.base.annotation.Translation;
import org.cs.base.exception.BusException;
import org.cs.blog.entity.Blog;
import org.cs.blog.service.BlogServer;
import org.cs.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright © 2018 pagoda Inc.
 * Description:
 *
 * @author wangjunjun
 * @date 2018/12/4
 */
@Controller
@RequestMapping("/blogController")
public class BlogController extends BaseController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlogServer blogServer;

    @GetMapping("/getBlogName")
    public String getBlogName(@Param("id") String id){
        logger.info("请求参数为:"+id);
        return blogServer.getBlogName(id);
    }

    @GetMapping("/hello")
    public Blog hello(){
        logger.info("请求hello");
        Blog blog = new Blog();
        blog.setId("1");
        blog.setName("HELLO WORLD");
        return blog;
    }

}
