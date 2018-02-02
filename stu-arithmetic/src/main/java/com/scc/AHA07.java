package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA07 {

	public static void main(String[] args) {
		getMaxPrimes(987654321);
	}

	public static void getMaxPrimes(int n) {
		int i = 2;
		while (n > 1) {
			if (n % i == 0) {
				n /= i;
			} else {
				i++;
			}
		}
		System.out.println(i);
	}
}
