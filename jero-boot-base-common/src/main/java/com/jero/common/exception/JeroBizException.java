package com.jero.common.exception;

import com.jero.common.constant.Code;

/**
 * @Description 全局业务异常类
 * @Author zer0
 * @Date 2020/10/14
 **/
public class JeroBizException extends RuntimeException {

    private static final long serialVersionUID = 3785352450518033758L;

    /**
     * 错误编码
     */
    private int errorCode;

    public JeroBizException(String message) {
        this(-1, message);
    }

    public JeroBizException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public JeroBizException(Code code) {
        this(code.getCode(), code.getMsg());
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}
