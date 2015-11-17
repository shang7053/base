package java8study;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 计算List中的元素的最大值，最小值，总和及平均值
 * 
 * @author Administrator
 *
 */
public class Test10 {
	/*
	 * //Get count, min, max, sum, and average for numbers List<Integer> primes
	 * = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29); IntSummaryStatistics
	 * stats = primes.stream().mapToInt((x) -> x) .summaryStatistics();
	 * System.out.println("Highest prime number in List : " + stats.getMax());
	 * System.out.println("Lowest prime number in List : " + stats.getMin());
	 * System.out.println("Sum of all prime numbers : " + stats.getSum());
	 * System.out.println("Average of all prime numbers : " +
	 * stats.getAverage());
	 * 
	 * Output : Highest prime number in List : 29 Lowest prime number in List :
	 * 2 Sum of all prime numbers : 129 Average of all prime numbers : 12.9
	 */
	public static void main(String[] args) {
		List<Integer> primes = Arrays
				.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x)
				.summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : "
				+ stats.getAverage());
	}
}
