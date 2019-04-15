package com.xiaotiangege.web;

/**
 * @author xiaotiangege 
 * @mailto 361807535@qq.com  
 * @Description 方法描述: TODO 
 * @createDate 2019年4月15日 下午2:35:19 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.xiaotiangege.service.utils.ApplicationContextUtil;


@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		
		//todo 可以添加加载配置信息的逻辑	
		ConfigurableApplicationContext context = application.run(args);
		ApplicationContextUtil.setApplicationContext(context);
	}
}
