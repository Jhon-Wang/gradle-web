package org.cs.utils;

import lombok.Data;

/**
 * Copyright © 2018 pagoda Inc.
 * Description:
 *
 * @author wangjunjun
 * @date 2018/12/5
 */
@Data
public class ResultInfo {

    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_MAPPING_FAILED = 100;
    public static final int ERROR_CODE_BUSINESS_FAILED = 130;

    /**
     * 错误码
     */
    private int errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 数据
     */
    private Object data;


}
