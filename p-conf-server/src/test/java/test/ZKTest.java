package test;

import java.util.List;

import org.junit.Test;

import com.xiaotiangege.service.zkutils.ZKClient;

/**
 * @author 小天哥哥 
 * @mailto 361807535@qq.com  
 * @Description TODO 
 * @createDate 2019年4月18日 上午10:34:18 
 */
public class ZKTest {

	@Test
	public void testZK() throws Exception {
		ZKClient p = new ZKClient("10.40.10.205:2181,10.40.10.206:2181,10.40.10.207:2181", "x-conf");
		List<String> list = p.children("/develop/kuaixin/kx-iaas/kx-repayment");
		System.out.println(list);
	}
}
