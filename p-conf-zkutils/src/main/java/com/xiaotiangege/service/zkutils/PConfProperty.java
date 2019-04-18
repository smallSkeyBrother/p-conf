package com.xiaotiangege.service.zkutils;

import java.util.Properties;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年4月18日 上午9:55:06
 */
public class PConfProperty {

	private static Properties properties;

	public static String getConf(String key) {
		return properties.getProperty(key);
	}

	public static Properties getProperties() {
		return properties;
	}
}
