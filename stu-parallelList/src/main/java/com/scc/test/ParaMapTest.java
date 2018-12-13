package com.scc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ParaListTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chengcai.shang@cmgplex.com
 * @date 2018年12月13日 上午10:10:28
 * 
 */
public class ParaMapTest {
	public static void main(String[] args) {
		final long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				// while (true) {
				test();
				// }
			}).start();
		}
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			long end = System.currentTimeMillis() - start;
			System.out.println("总共执行" + end + "毫秒，约合" + (end / 1000.00 / 60.00) + "分钟");
		}));
	}

	/**
	 * @Title: test
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @param i
	 * @date 2018年12月13日 上午10:33:30
	 */
	private static void test() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		System.out.println(Thread.currentThread().getName() + "->" + list.size() + "->" + list);
		Map<String, String> map = new HashMap<>();
		list.parallelStream().forEach((s) -> {
			map.put(s, s);
		});
		System.out.println(Thread.currentThread().getName() + "->" + list.size() + "/" + map.size() + "->" + map);
		// List<String> list3 = list.parallelStream().map(s -> s).collect(Collectors.toList());
		// if (list3.stream().distinct().count() != list3.size()) {
		// // 如果有重复，打印
		// System.out.println("error!list=" + list);
		// } else if (list3.stream().anyMatch(s -> null == s)) {
		// // 如果有null值也打印
		// System.out.println("error!list=" + list);
		// }
		// System.out.println(Thread.currentThread().getName() + "->" + list.size() + "/" + list2.size() + "/"
		// + list3.size() + "->" + list3);
	}
}
