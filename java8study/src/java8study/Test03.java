package java8study;

import java.util.Arrays;
import java.util.List;

/**
 * 使用Lambda表达式遍历List集合
 * 
 * @author Administrator
 *
 */
public class Test03 {
	/*
	 * //Prior Java 8 : List features = Arrays.asList("Lambdas",
	 * "Default Method", "Stream API", "Date and Time API"); for (String feature
	 * : features) { System.out.println(feature); }
	 * 
	 * //In Java 8: List features = Arrays.asList("Lambdas", "Default Method",
	 * "Stream API", "Date and Time API"); features.forEach(n ->
	 * System.out.println(n));
	 * 
	 * // Even better use Method reference feature of Java 8 // method reference
	 * is denoted by :: (double colon) operator // looks similar to score
	 * resolution operator of C++ features.forEach(System.out::println);
	 * 
	 * Output: Lambdas Default Method Stream API Date and Time API
	 * 方法引用是使用两个冒号::这个操作符号。
	 */
	public static void main(String[] args) {
		List<String> features = Arrays.asList("Lambdas", "Default Method",
				"Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}
		System.out.println("-----------------------------");
		features.forEach((n) -> {
			System.out.println(n);
		});
		System.out.println("-----------------------------");
		features.forEach(System.out::println);
	}
}
