package org.cs.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;

/**
 * Copyright © 2018 pagoda Inc.
 * Description:
 *
 * @author wangjunjun
 * @date 2018/12/5
 */
public class BaseHandler implements HandlerMethodReturnValueHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        Class<?> controllerClass = returnType.getContainingClass();
        returnType.getMethodAnnotation(ResponseBody.class);

        return controllerClass.isAnnotationPresent(RestController.class)
                || controllerClass.isAnnotationPresent(ResponseBody.class)
                || returnType.getMethodAnnotation(ResponseBody.class) != null;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        logger.info("结果:"+returnValue);
        ResultInfo resultInfo = new ResultInfo();
        if (returnValue instanceof ResultInfo){
            resultInfo = (ResultInfo)returnValue;
        }else {
            resultInfo.setData(returnValue);
        }

        mavContainer.setRequestHandled(true);

        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.getWriter().write(JSON.toJSONString(resultInfo));

    }
}
