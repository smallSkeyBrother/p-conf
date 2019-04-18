package com.xiaotiangege.service.api.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 小天哥哥 
 * @mailto 361807535@qq.com  
 * @Description TODO 
 * @createDate 2019年4月18日 下午5:50:06 
 */

@Setter
@Getter
@JsonIgnoreProperties
public class PageParam extends BaseDomain{

	private static final long serialVersionUID = 3577337431094258642L;

	/**
	 * 当前页码
	 */
	private int pageNo;
	
	/**
	 * 页面大小
	 */
	private int pageSize;
	
	/**
	 * 下一页
	 */
	private int nextPage;
	
}
