package com.xiaotiangege.service.utils;

import org.springframework.context.ApplicationContext;

/**
 * @author 小天哥哥  
 * @mailto 361807535@qq.com  
 * @Description 容器工具类 
 * @createDate 2019年4月15日 下午2:35:19 
 */

public class ApplicationContextUtil {

	private static ApplicationContext context;
	
	public static void setApplicationContext(ApplicationContext applicationContext) {
		ApplicationContextUtil.context = applicationContext;
	} 
	
	public static ApplicationContext getApplicationContext() {
		return ApplicationContextUtil.context;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) context.getBean(name);
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return (T) context.getBean(clazz);
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		return context.getBean(name, clazz);
	}
	
}
