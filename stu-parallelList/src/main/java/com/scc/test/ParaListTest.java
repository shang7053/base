package com.scc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: ParaListTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chengcai.shang@cmgplex.com
 * @date 2018年12月13日 上午10:10:28
 * 
 */
public class ParaListTest {
	public static void main(String[] args) {
		final long start = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			new Thread(() -> {
				while (true) {
					test();
				}
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
		// System.out.println(Thread.currentThread().getName() + "->" + list.size() + "->" + list);
		// List<String> list2 = new ArrayList<>();
		// list.parallelStream().forEach((s) -> {
		// list2.add(s);
		// });
		// System.out.println(Thread.currentThread().getName() + "->" + list.size() + "/" + list2.size() + "->" +
		// list2);
		List<String> list3 = list.parallelStream().map(s -> s).collect(Collectors.toList());
		if (list3.stream().distinct().count() != list3.size()) {
			// 如果有重复，打印
			System.out.println("error!list=" + list);
		} else if (list3.stream().anyMatch(s -> null == s)) {
			// 如果有null值也打印
			System.out.println("error!list=" + list);
		}
		// System.out.println(Thread.currentThread().getName() + "->" + list.size() + "/" + list2.size() + "/"
		// + list3.size() + "->" + list3);
	}
}
