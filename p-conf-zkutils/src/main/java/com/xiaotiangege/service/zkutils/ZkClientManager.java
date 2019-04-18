package com.xiaotiangege.service.zkutils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年4月18日 下午2:58:20
 */
public class ZkClientManager {
	/**
	 * client缓存池
	 */
	private static final Map<String, ZKClient> clients = new ConcurrentHashMap<>(16);

	private static final String DEFAULT_KEY = "default";

	public static ZKClient zkClient(String zkServers, String namespace) {
		return zkClient(DEFAULT_KEY, zkServers, namespace);
	}

	/**
	 * 获取zkClient实例
	 * 
	 * @param zkClusterKey
	 * @param zkServers
	 * @param namespace
	 * @return
	 */
	public static ZKClient zkClient(String zkClusterKey, String zkServers, String namespace) {
		synchronized (ZkClientManager.class) {
			ZKClient client = null;
			if (clients.containsKey(zkServers)) {
				client = clients.get(zkServers);
			} else {
				client = new ZKClient(zkServers, namespace);
				clients.put(zkServers, client);
			}
			return client;
		}
	}
}
