package com.jero.common.exception;

/**
 * @Description 时间为空异常类
 * @Author zero
 * @Date 2020/11/7
 **/
public class DateNullException  extends RuntimeException {

    private final String error;

    public DateNullException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

}
