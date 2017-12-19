package com.scc.stu.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @ClassName: ThreadTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年6月7日 下午1:01:45
 * 
 */
public class ThreadTest {
	private Map<String, Thread> runThreads = new HashMap<>();

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @author shangchengcai@voole.com
	 * @date 2017年6月7日 下午1:01:45
	 */
	public ThreadTest() {
		this.runThreads.put("aa", new Thread(() -> {
			System.out.println(1 / 0);
			System.out.println("go on");
		}));
		for (Entry<String, Thread> t : this.runThreads.entrySet()) {
			t.getValue().start();
		}
		for (Entry<String, Thread> t : this.runThreads.entrySet()) {
			System.out.println(t.getValue().isInterrupted());
			if (!t.getValue().isInterrupted()) {
				System.out.println("thread down");
				t.getValue().start();
			}
		}
	}

	public static void main(String[] args) {
		// new ThreadTest();
		// DateTimeFormatter format = new SimpleDateFormat("yyyyMMddHHmmss");
		// System.out.println(DateTime.parse("20170621185337", format).getMillis());
	}
}
