package com.xiaotiangege.service.zkutils;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description 配置项目
 * @createDate 2019年5月14日 下午4:47:51
 */
public interface PConfChangeWatcher {

	void add(String key, String value);

	void update(String key, String value);

	void delete(String key);
}
