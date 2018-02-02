package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA10 {

	public static void main(String[] args) {
		// c=n!/(m!(n-m)!)
		System.out.println(climbStairs(36));
	}

	private static int climbStairs(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		int f1 = 1, f2 = 2, f3 = 4;
		int result = 0;
		for (int i = 4; i <= n; i++) {
			result = f1 + f2 + f3;
			f1 = f2;
			f2 = f3;
			f3 = result;
		}
		return result;
	}
}
