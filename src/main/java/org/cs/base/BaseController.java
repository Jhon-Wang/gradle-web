package org.cs.base;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright © 2018 pagoda Inc.
 * Description:
 *
 * @author wangjunjun
 * @date 2018/12/6
 */
public class BaseController {

    @ExceptionHandler
    public void exp(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setErrorCode(ResultInfo.ERROR_CODE_MAPPING_FAILED);
        resultInfo.setErrorMsg(ex.getMessage());
        response.getWriter().write(JSON.toJSONString(resultInfo));
    }
}
