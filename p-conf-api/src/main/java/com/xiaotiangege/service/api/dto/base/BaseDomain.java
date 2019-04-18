package com.xiaotiangege.service.api.dto.base;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年4月18日 下午5:21:27
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDomain implements Serializable {

	private static final long serialVersionUID = -2215327077949716320L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
