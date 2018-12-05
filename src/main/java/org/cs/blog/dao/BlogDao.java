package org.cs.blog.dao;

import org.apache.ibatis.annotations.Param;
import org.cs.blog.entity.Blog;

import java.util.Map;

/**
 * Copyright © 2018 pagoda Inc.
 * Description:
 *
 * @author wangjunjun
 * @date 2018/12/3
 */
public interface BlogDao {

    Blog selectByCondiction(@Param(value = "condition") Map<String, String> condition);

}
