package com.scc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName: AppleUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chengcai.shang@cmgplex.com
 * @date 2018年12月27日 下午2:09:36
 * 
 */
public class AppleUtil {
	public static boolean isGreenApple(Apple apple) {
		return "green".equalsIgnoreCase(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return null == apple.getWeight() ? false : apple.getWeight() > 150;
	}

	public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p) {
		List<Apple> resApples = new ArrayList<Apple>();
		for (Apple apple : apples) {
			if (p.test(apple)) {
				resApples.add(apple);
			}
		}
		return resApples;
	}
}
