package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA06 {

	public static void main(String[] args) {
		int t = 0;
		for (int i = 2; i < 100; i++) {
			if (isPrime(i)) {
				t += i;
			}
		}
		System.out.println(t);
	}

	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
