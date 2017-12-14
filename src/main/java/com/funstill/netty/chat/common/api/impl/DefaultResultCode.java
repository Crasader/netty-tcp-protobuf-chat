package com.funstill.netty.chat.common.api.impl;


import com.funstill.netty.chat.common.api.ResultCode;

/**
 * 默认实现,此enum只存所有项目公共的状态码,涉及到具体业务请在具体项目中再实现ResultCode
 * @author liukaiyang
 */
public enum DefaultResultCode implements ResultCode {

	//常用通用异常,格式-100-0-*
	ILLEGAL_ARGUMENT(10000, "非法参数"),
	SYSTEM_ERROR_UNKOWN(10001, "未知系统错误"),
	SYSTEM_ERROR_DAO(10002, "数据层异常出错"),
    
    //权限相关 格式-100-1-*
	AUTH_ERROR_NOT_RIGHT(10011, "没有权限"),
	AUTH_ERROR_NOT_LOGIN(10012, "请登陆后重试"),
   
    //数据操作 格式-100-2-*
    DATA_ERROR_SELECT_IS_NULL(10020, "该数据不存在或已被删除"),
    DATA_ERROR_INSERT(10021, "新增失败"),
    DATA_ERROR_UPDATE(10022, "更新失败"),
    DATA_ERROR_DELETE(10023, "删除失败"),
    
    //输入校验
    COMMIT_ERROR_REPEAT(10030, "请勿重复提交"),
    //上传文件
    UPLOAD_ERROR(10030, "上传失败"),
    
    //请求
    REQUEST_ERROR_FAIL(400, "请求错误"),
    REQUEST_ERROR_NOT_AUTH(401, "未授权"),
    REQUEST_ERROR_FORBIDDEN(403, "禁止访问"),
    REQUEST_ERROR_NOT_FIND(404, "您访问的地址不存在或已删除"),
    //自定义
    REQUEST_ERROR_INVALID_METHOD(400, "请求方法不正确"),
    ;

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return code + ":" + msg;
	}

    private DefaultResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
