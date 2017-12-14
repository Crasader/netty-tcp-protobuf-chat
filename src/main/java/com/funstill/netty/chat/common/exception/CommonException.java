package com.funstill.netty.chat.common.exception;


import com.funstill.netty.chat.common.api.ResultCode;

/**
 * 公共异常
 * @author liukaiyang 2016年12月16日
 */
public class CommonException extends RuntimeException {
	
    private static final long serialVersionUID = 5518441400937421040L;
    
	private ResultCode resultCode;

    public CommonException() {
        super();
    }

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public CommonException(Throwable throwable) {
        super(throwable);
    }

    public CommonException(ResultCode resultCode) {
    	super(resultCode.getCode()+resultCode.getMsg());
    	this.setResultCode(resultCode);
    }
    public CommonException(ResultCode resultCode,String msg) {
    	super(resultCode.getCode()+msg);
    	resultCode.setMsg(msg);
    	this.resultCode=resultCode;
    }

    public CommonException(ResultCode resultCode, Throwable throwable) {
    	super(resultCode.getMsg(), throwable);
    	this.resultCode=resultCode;
    }

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

}
