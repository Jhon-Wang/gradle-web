package org.cs.base.exception;

import lombok.Data;

import java.io.IOException;

/**
 * Copyright © 2018 pagoda Inc.
 * Description:
 *
 * @author wangjunjun
 * @date 2018/12/7
 */
public class BusException extends Exception {

    public BusException() {
    }

    public BusException(String message) {
        super(message);
    }

    public BusException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusException(Throwable cause) {
        super(cause);
    }

    public BusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
