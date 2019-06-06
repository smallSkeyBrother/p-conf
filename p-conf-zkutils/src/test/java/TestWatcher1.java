import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年6月6日 上午11:32:29
 */
public class TestWatcher1 {
	static String path = "/develop/kuaixin/kx-k-loan/k-loan-customer-service";
	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("10.40.10.205:2181,10.40.10.206:2181,10.40.10.207:2181")
			.sessionTimeoutMs(60000).namespace("x-conf").connectionTimeoutMs(15000).retryPolicy(new ExponentialBackoffRetry(1000, 3))
			.build();

	public static void main(String[] args) throws Exception {
		client.start();
		//client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, "init".getBytes());
		final PathChildrenCache cache = new PathChildrenCache(client, path, true);
		cache.start(PathChildrenCache.StartMode.NORMAL);
		cache.getListenable().addListener(new PathChildrenCacheListener() {
			
			@Override
			public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
				PathChildrenCacheEvent.Type type = event.getType();
				switch (type) {
				case CHILD_ADDED:
					 
				case CHILD_UPDATED:
					 
				case CHILD_REMOVED:
					ChildData data = event.getData();
					String value = new String(data.getData());
					String path = data.getPath();
					Stat stat = data.getStat();
					
					String key = path.substring(path.lastIndexOf("/") + 1, path.length());
					
					System.out.println("=====> event type =>" + event.getType().toString());
					System.out.println("=====> Node data =>" +value);
					System.out.println("=====> Node path =>" +path);
					System.out.println("=====> Node key =>" +key);
					System.out.println("=====> Node stat =>" +stat.toString());
					break;
				default:
					break;
				}
			}
		});

		//client.setData().forPath(path, "i love you".getBytes());
		Thread.sleep(1000);
		//client.delete().deletingChildrenIfNeeded().forPath(path);
		Thread.sleep(1000000);
		//cache.close();
		//client.close();
	}

}
