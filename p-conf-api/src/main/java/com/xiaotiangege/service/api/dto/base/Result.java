package com.xiaotiangege.service.api.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年4月18日 下午5:24:51
 */
@Getter
@Setter
@JsonIgnoreProperties
public class Result<T> extends BaseDomain {

	private static final long serialVersionUID = -2323428265630782361L;

	private static final String SUCCESS_RESULT = "200";
	
	private String code;
	
	private String msg;
	
	private T data;
	
	private String remark;

	private Result(String code, String msg, T data, String remark) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.remark = remark;
	}

	public Result() {}

}
