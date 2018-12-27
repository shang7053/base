package com.scc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chengcai.shang@cmgplex.com
 * @date 2018年12月27日 下午2:07:48
 * 
 */
public class Test {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	/**
	 * @Title: test5
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:56:22
	 */
	private static void test5() {
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green", 200));
		apples.add(new Apple("green", 300));
		apples.add(new Apple("red", 100));
		apples.add(new Apple("red", 200));
		apples.add(new Apple("green", 200));
		apples.add(new Apple("green", 300));
		apples.add(new Apple("red", 100));
		apples.add(new Apple("red", 200));
		apples.add(new Apple("green", 200));
		apples.add(new Apple("green", 300));
		apples.add(new Apple("red", 100));
		apples.add(new Apple("red", 200));
		apples.add(new Apple("green", 200));
		apples.add(new Apple("green", 300));
		apples.add(new Apple("red", 100));
		apples.add(new Apple("red", 200));
		apples.add(new Apple("green", 200));
		apples.add(new Apple("green", 300));
		apples.add(new Apple("red", 100));
		apples.add(new Apple("red", 200));
		List<Long> ntimes = new ArrayList<Long>();
		List<Long> stimes = new ArrayList<Long>();
		List<Long> pstimes = new ArrayList<Long>();
		for (int i = 0; i < 1000; i++) {
			ntimes.add(testNormal(apples));
			stimes.add(testStream(apples));
			pstimes.add(testPstream(apples));
		}
		System.out.println(ntimes.stream().collect(Collectors.averagingDouble(l -> l)) + "");
		System.out.println(stimes.stream().collect(Collectors.averagingDouble(l -> l)) + "");
		System.out.println(pstimes.stream().collect(Collectors.averagingDouble(l -> l)) + "");
	}

	/**
	 * @Title: testPstream
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:59:50
	 * @param apples
	 * @return
	 */
	private static long testPstream(List<Apple> apples) {
		long start = System.currentTimeMillis();
		apples.parallelStream().forEach((apple) -> {
			apple.getColor();
			apple.getWeight();
		});
		return System.currentTimeMillis() - start;

	}

	/**
	 * @Title: testStream
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:58:54
	 * @param apples
	 * @return
	 */
	private static long testStream(List<Apple> apples) {
		long start = System.currentTimeMillis();
		apples.stream().forEach((apple) -> {
			apple.getColor();
			apple.getWeight();
		});
		return System.currentTimeMillis() - start;
	}

	/**
	 * @Title: testNormal
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:57:30
	 * @param apples
	 * @return
	 */
	private static long testNormal(List<Apple> apples) {
		long start = System.currentTimeMillis();
		for (Apple apple : apples) {
			apple.getColor();
			apple.getWeight();
		}
		return System.currentTimeMillis() - start;
	}

	/**
	 * @Title: test4
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:48:36
	 */
	private static void test4() {
		System.out.println("test4 start");
		Map<String, List<Apple>> applesMap = new HashMap<String, List<Apple>>();
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green", 200));
		apples.add(new Apple("green", 300));
		apples.add(new Apple("red", 100));
		apples.add(new Apple("red", 200));
		applesMap = apples.stream().filter(a -> a.getWeight() > 150).collect(Collectors.groupingBy(Apple::getColor));
		System.out.println(applesMap);
		System.out.println("test4 end---------------------------------");

	}

	/**
	 * @Title: test3
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:36:38
	 */
	private static void test3() {
		System.out.println("test3 start");
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green"));
		List<Apple> filterApples = apples.stream().filter(a -> "green".equalsIgnoreCase(a.getColor()))
				.collect(Collectors.toList());
		System.out.println(filterApples);
		System.out.println("test3 end---------------------------------");
	}

	/**
	 * @Title: test2
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:22:43
	 */
	private static void test2() {
		System.out.println("test2 start");
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green"));
		List<Apple> filterApples = AppleUtil.filterApples(apples, (Apple a) -> {
			return "green".equalsIgnoreCase(a.getColor());
		});
		System.out.println(filterApples);
		filterApples = AppleUtil.filterApples(apples, a -> {
			return "green".equalsIgnoreCase(a.getColor());
		});
		System.out.println(filterApples);
		filterApples = AppleUtil.filterApples(apples, a -> "green".equalsIgnoreCase(a.getColor()));
		System.out.println(filterApples);
		System.out.println("test2 end---------------------------------");

	}

	/**
	 * @Title: 方法传递 谓词
	 * @Description: 此测试，只为学习lambda原理，实际直接使用匿名lamdba
	 * @author chengcai.shang@cmgplex.com
	 * @date 2018年12月27日 下午2:13:41
	 */
	private static void test1() {
		System.out.println("test1 start");
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple("green"));
		List<Apple> filterApples = AppleUtil.filterApples(apples, AppleUtil::isGreenApple);
		System.out.println(filterApples);
		apples.add(new Apple(200));
		filterApples = AppleUtil.filterApples(apples, AppleUtil::isHeavyApple);
		System.out.println(filterApples);
		System.out.println("test1 end---------------------------------");
	}
}
