package com.xiaotiangege.service.zkutils;

import java.util.List;
import java.util.Objects;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description zk客户端初始化类
 * @createDate 2019年4月18日 上午10:46:51
 */
public class ZKClient {
	private CuratorFramework client;
	private static final int DEFAULT_RETRY_INTERVAL = 1000;
	private static final int DEFAULT_RETRY_TIMES = 3;
	private static final int DEFAULT_CONNECTION_TIMEOUT = 3000;
	private static final int DEFAULT_SESSION_TIMEOUT = 3000;
	private static ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(DEFAULT_RETRY_INTERVAL,
			DEFAULT_RETRY_TIMES);

	public ZKClient(String zkServers, String namespace, int connectionTimeoutMs, int sessionTimeoutMs) {
		this.client = CuratorFrameworkFactory.builder().connectString(zkServers).namespace(namespace)
				.retryPolicy(retryPolicy).connectionTimeoutMs(connectionTimeoutMs).sessionTimeoutMs(sessionTimeoutMs)
				.build();
		this.client.start();
	}

	public ZKClient(String zkServers, String namespace) {
		this(zkServers, namespace, DEFAULT_CONNECTION_TIMEOUT, DEFAULT_SESSION_TIMEOUT);
	}

	public CuratorFramework getClient() {
		return this.client;
	}

	/**
	 * 判断节点是否存在
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public boolean isExist(String path) throws Exception {
		return this.client.checkExists().forPath(path) != null;
	}

	/**
	 * 判断是否节点不存在
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public boolean NotExist(String path) throws Exception {
		return !this.isExist(path);
	}

	/**
	 * 创建节点
	 * 
	 * @param path
	 * @param value
	 * @throws Exception
	 */
	public void createNode(String path, CreateMode mode, byte... value) throws Exception {
		if (this.NotExist(path)) {
			if (Objects.isNull(value) && value.length > 0) {
				this.client.create().withMode(mode).forPath(path, value);
			} else {
				this.client.create().withMode(mode).forPath(path);
			}
		}
	}

	/**
	 * 删除节点
	 * 
	 * @param path
	 * @throws Exception
	 */
	public void deleteNode(String path) throws Exception {
		if (this.isExist(path)) {
			this.client.delete().forPath(path);
		}
	}

	/**
	 * 更新节点，如果不存在则添加
	 * 
	 * @param path
	 * @param value
	 * @throws Exception
	 */
	public void updateNode(String path, byte... value) throws Exception {
		if (this.isExist(path)) {
			this.client.setData().forPath(path, value);
		} else {
			this.createNode(path, CreateMode.PERSISTENT, value);
		}
	}

	/**
	 * 获取子节点元素
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<String> children(String path) throws Exception {
		return (List<String>) this.client.getChildren().forPath(path);
	}

}
