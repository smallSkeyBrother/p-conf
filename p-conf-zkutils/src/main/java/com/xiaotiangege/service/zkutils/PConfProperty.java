package com.xiaotiangege.service.zkutils;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年4月18日 上午9:55:06
 */
@Slf4j
public class PConfProperty extends PropertyPlaceholderConfigurer {
	private String base;
	private ZKClient zkClient;
	private static Properties properties;

	public static String getConf(String key) {
		return properties.getProperty(key);
	}

	public static Properties getProperties() {
		return properties;
	}

	public PConfProperty(Properties propertiesParam) {
		properties = propertiesParam;
	}

	public PConfProperty() {
		String zkServers = System.getProperty("xconf.zkServers");
		String enviorment = System.getProperty("xconf.enviroment");
		String company = System.getProperty("xconf.company");
		String project = System.getProperty("xconf.project");
		String service = System.getProperty("xconf.service");
		this.base = StringUtils.join(new String[] { "/", enviorment, "/", company, "/", project, "/", service });
		this.zkClient = ZkClientManager.zkClient(zkServers, "config");
	}

	/**
	 * 从zk上拿到配置数据，赋值给容器配置数据，自动注入到需要的Bean中 @Value("${xxx}")
	 */
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		Iterator<Entry<Object, Object>> it = props.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Object, Object> entry = it.next();
			properties.put(entry.getKey(), entry.getValue());
		}

		props = properties;
		super.processProperties(beanFactoryToProcess, props);
	}

	public void loadProperties() throws Exception {
		this.loadZkConf();
	}

	/**
	 * 从zk上加载数据
	 * @throws Exception 
	 */
	private void loadZkConf() throws Exception {
		try {
			if (this.zkClient.NotExist(this.base)) {
				throw new Exception("zk node is not exist , path = " + this.base);
			} else {
				if (Objects.isNull(properties)) {
					properties = new Properties();
				}
				List<String> children = this.zkClient.children(this.base);

				for (String key : children) {
					String value = this.zkClient.getData(StringUtils.join(new String[] { this.base, "/", key }));
					properties.put(key.trim(), value.trim());
				}

				properties.setProperty("zookeeper.addr", System.getProperty("xconf.zkServers"));
			}
		} catch (Exception e) {
			throw new Exception("");
		}
	}
}
