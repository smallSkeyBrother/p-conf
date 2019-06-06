package com.xiaotiangege.service.zkutils;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.zookeeper.data.Stat;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年6月6日 上午11:23:11
 */
public class PConfNodeListener implements PathChildrenCacheListener {

	@Override
	public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
		PathChildrenCacheEvent.Type type = event.getType();
		switch (type) {
		case CHILD_ADDED:{
			ChildData data = event.getData();
			String value = new String(data.getData());
			String paht = data.getPath();
			Stat stat = data.getStat();
			break;
		}
			
		case CHILD_UPDATED:
			break;
		case CHILD_REMOVED:
			break;
		default:
			break;
		}
	}

	public void watcherNode(CuratorFramework client, String path) throws Exception {
		PathChildrenCache cache = new PathChildrenCache(client, path, true);
		cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
		cache.getListenable().addListener(this);
	}

	private static class Conf {
		String key;
		String value;
	}
	
	private void add(Conf conf) {
		
	}
}
