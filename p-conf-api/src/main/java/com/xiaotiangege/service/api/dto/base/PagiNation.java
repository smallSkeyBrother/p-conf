package com.xiaotiangege.service.api.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年4月18日 下午5:53:21
 */
@Getter
@Setter
@JsonIgnoreProperties
public class PagiNation<T> extends BaseDomain {

	private static final long serialVersionUID = 2466518513756253130L;

	/**
	 * 当前页码
	 */
	private int pageNo;

	/**
	 * 页面大小
	 */
	private int pageSize;

	/**
	 * 总记录数
	 */
	private int total;

	/**
	 * 总页数
	 */
	private int pages;
	
	/**
	 * 查询数据
	 */
	private T data;

	public PagiNation() {
	}

	@SuppressWarnings("unchecked")
	public static PagiNation create(int pageNo, int pageSize, int total, int pages) {
		return new PagiNation(pageNo, pageSize, total, pages, null);
	}
	
	public static <T> PagiNation<T> create(int pageNo, int pageSize, int total, int pages, T data) {
		return new PagiNation<T>(pageNo, pageSize, total, pages, data);
	}

	private PagiNation(int pageNo, int pageSize, int total, int pages, T data) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.total = total;
		this.pages = pages;
		this.data = data;
	}
}
