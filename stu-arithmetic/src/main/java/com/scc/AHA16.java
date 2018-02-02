package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA16 {

	public static void main(String[] args) {
		int total = 0;
		for (int i = 1; i < 10000000; i++) {
			String str = String.valueOf(i);
			if (i % 7 == 0 || str.lastIndexOf("7") == str.length() - 1) {
				total++;
			}
		}
		System.out.println(total);
	}

}
