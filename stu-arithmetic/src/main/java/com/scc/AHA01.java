package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA01 {

	public static void main(String[] args) {
		// for (int i = 0; i < 10; i++) {
		// int a = i * i * i;
		// for (int j = 0; j < 10; j++) {
		// int b = j * j * j;
		// for (int k = 0; k < 10; k++) {
		// int c = k * k * k;
		// int sum = a + b + c;
		// int total = Integer.valueOf(i + "" + j + "" + k + "");
		// if (sum == total) {
		// System.out.println(sum);
		// }
		// }
		// }
		// }
		for (int i = 100; i < 999; i++) {
			String temp = String.valueOf(i);
			int a, b, c, total;
			a = Integer.valueOf(temp.substring(0, 1));
			b = Integer.valueOf(temp.substring(1, 2));
			c = Integer.valueOf(temp.substring(2, 3));
			total = a * a * a + b * b * b + c * c * c;
			if (i == total) {
				System.out.println(i);
			}
		}
	}

}
