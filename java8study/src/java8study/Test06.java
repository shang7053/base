package java8study;

import java.util.Arrays;
import java.util.List;

/**
 * 使用Lambda实现Map 和 Reduce
 * 
 * @author Administrator
 *
 */
public class Test06 {
	/*
	 * 最流行的函数编程概念是map，它允许你改变你的对象，在这个案例中，我们将costBeforeTeax集合中每个元素改变了增加一定的数值，
	 * 我们将Lambda表达式 x -> x*x传送map()方法，这将应用到stream中所有元素。然后我们使用 forEach()
	 * 打印出这个集合的元素.
	 * 
	 * // applying 12% VAT on each purchase // Without lambda expressions: List
	 * costBeforeTax = Arrays.asList(100, 200, 300, 400, 500); for (Integer cost
	 * : costBeforeTax) { double price = cost + .12*cost;
	 * System.out.println(price); }
	 * 
	 * // With Lambda expression: List costBeforeTax = Arrays.asList(100, 200,
	 * 300, 400, 500); costBeforeTax.stream().map((cost) -> cost + .12*cost)
	 * .forEach(System.out::println);
	 * 
	 * Output 112.0 224.0 336.0 448.0 560.0 112.0 224.0 336.0 448.0 560.0
	 * reduce() 是将集合中所有值结合进一个，Reduce类似SQL语句中的sum(), avg() 或count(),
	 * 
	 * // Applying 12% VAT on each purchase // Old way: List costBeforeTax =
	 * Arrays.asList(100, 200, 300, 400, 500); double total = 0; for (Integer
	 * cost : costBeforeTax) { double price = cost + .12*cost; total = total +
	 * price;
	 * 
	 * } System.out.println("Total : " + total);
	 * 
	 * // New way: List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
	 * double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost)
	 * .reduce((sum, cost) -> sum + cost) .get(); System.out.println("Total : "
	 * + bill);
	 * 
	 * Output Total : 1680.0 Total : 1680.0
	 */
	public static void main(String[] args) {
		//map
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			System.out.println(price);
		}
		System.out.println("---------------------");
		// With Lambda expression:
		costBeforeTax.stream().map((cost) -> cost + .12 * cost)
				.filter((n) -> n > 200).forEach(System.out::println);
		// reduce
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			total = total + price;

		}
		System.out.println("Total : " + total);
		System.out.println("______________________________________");
		// New way:
		System.out.println("Total : " + costBeforeTax.stream().map((cost) -> cost + .12 * cost)
				.reduce((sum, cost) -> sum + cost).get());
	}
}
