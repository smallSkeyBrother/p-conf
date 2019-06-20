package com.xiaotiangege.service.zkutils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年6月6日 上午11:23:11
 */
public class PConfNodeListener implements PathChildrenCacheListener, PConfChangeWatcher {
	public PConfNodeListener() {
	}

	public void watcherNode(CuratorFramework client, String path) throws Exception {
		@SuppressWarnings("resource")
		PathChildrenCache cache = new PathChildrenCache(client, path, true);
		cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
		cache.getListenable().addListener(this);
	}

	@Override
	public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
		PathChildrenCacheEvent.Type type = event.getType();
		ChildData data = event.getData();
		String value = new String(data.getData());
		String path = data.getPath();
		String key = path.substring(path.lastIndexOf("/") + 1, path.length());
		switch (type) {
		case CHILD_ADDED: {
			this.add(key, value);
			break;
		}

		case CHILD_UPDATED: {
			this.update(key, value);
			break;
		}

		case CHILD_REMOVED: {
			this.delete(key);
			break;
		}

		default:
			break;
		}
	}

	@Override
	public void add(String key, String value) {
		PConfProperty.getProperties().put(key, value);
	}

	@Override
	public void update(String key, String value) {
		PConfProperty.getProperties().put(key, value);
	}

	@Override
	public void delete(String key) {
		// TODO delete
		// PConfProperty.getProperties().get(key);
	}
}
