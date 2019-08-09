package com.tx.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <pre>
 * Description	公共返回对象
 * Copyright:	Copyright (c)2014  
 * Company:		上海天地汇
 * Author:		xubinbin
 * Version:		1.0  
 * Created at:	2016年12月9日 下午1:50:47  
 * </pre>
 */
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class BaseResponse<T> implements Serializable {
	private static final long serialVersionUID = -8245281394202383963L;

	/**
	 * 接口调用返回是否成功
	 */
	private boolean success;

	/**
	 * 接口调用返回消息
	 */
	private String message;

	/**
	 * 接口调用返回代码
	 */
	private String code;

	/**
	 * 接口调用返回内容
	 */
	private T body;

	public BaseResponse(String code, String message, T body) {
		super();
		this.code = code;
		this.message = message;
		this.body = body;
	}

	public BaseResponse(String code, String message, T body, boolean success) {
		super();
		this.code = code;
		this.message = message;
		this.body = body;
		this.success = success;
	}

	public BaseResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public BaseResponse(String code) {
		super();
		this.code = code;
	}

	public BaseResponse() {

	}

}
