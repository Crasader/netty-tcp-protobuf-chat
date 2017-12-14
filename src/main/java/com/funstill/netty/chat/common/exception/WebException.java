package com.funstill.netty.chat.common.exception;


import com.funstill.netty.chat.common.api.ResultCode;

/**
 * web异常
 * @author liukaiyang 2016年12月16日
 */
public class WebException extends CommonException {
	
    private static final long serialVersionUID = -3540434763194766787L;

	public WebException() {
        super();
    }

    public WebException(String msg) {
        super(msg);
    }

    public WebException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public WebException(Throwable throwable) {
        super(throwable);
    }

    public WebException(ResultCode resultCode) {
    	super(resultCode);
    }
    public WebException(ResultCode resultCode,String msg) {
    	super(resultCode,msg);
    }

    public WebException(ResultCode resultCode, Throwable throwable) {
    	super(resultCode,throwable);
    	this.setResultCode(resultCode);
    }
}
