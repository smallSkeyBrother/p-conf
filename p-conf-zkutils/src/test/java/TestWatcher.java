import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author 小天哥哥
 * @mailto 361807535@qq.com
 * @Description TODO
 * @createDate 2019年6月6日 上午11:32:29
 */
public class TestWatcher {
	static String path = "/develop/kuaixin/kx-k-loan/k-loan-customer-service";
	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("10.40.10.205:2181,10.40.10.206:2181,10.40.10.207:2181")
			.sessionTimeoutMs(60000).connectionTimeoutMs(15000).retryPolicy(new ExponentialBackoffRetry(1000, 3))
			.build();

	public static void main(String[] args) throws Exception {
		client.start();
		//client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, "init".getBytes());
		final NodeCache cache = new NodeCache(client, path, false);
		cache.start(true);
		cache.getListenable().addListener(new NodeCacheListener() {
			@Override
			public void nodeChanged() throws Exception {
				ChildData currentData = cache.getCurrentData();
				String data = currentData == null ? "" : new String(currentData.getData());
				System.out.println("=====> Node data update, new Data: " + data);
			}
		});

		client.setData().forPath(path, "i love you".getBytes());
		Thread.sleep(1000);
		client.delete().deletingChildrenIfNeeded().forPath(path);
		Thread.sleep(10000);
		cache.close();
		client.close();
	}

}
