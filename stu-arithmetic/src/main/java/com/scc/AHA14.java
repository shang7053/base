package com.scc;

import java.util.Arrays;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA14 {
	public static int[] a = new int[10];
	public static int[] book = new int[10];
	public static int total = 0;

	public static void main(String[] args) {
		dfs(1);
		System.out.println(total / 2);
	}

	public static void dfs(int step) {
		if (step == 10) {
			if (a[1] * 100 + a[2] * 10 + a[3] + a[4] * 100 + a[5] * 10 + a[6] == a[7] * 100 + a[8] * 10 + a[9]) {
				total++;
				System.out.println(Arrays.toString(a));
				return;
			}
		}
		for (int i = 1; i < 10; i++) {
			if (book[i] == 0) {
				a[step] = i;
				book[i] = i;
				dfs(step + 1);
				book[i] = 0;
			}
		}
		return;
	}
}
