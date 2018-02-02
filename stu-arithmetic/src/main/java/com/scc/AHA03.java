package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA03 {

	public static void main(String[] args) {
		int total = 0;
		for (int i = 0; i < 123456; i++) {
			String str = String.valueOf(i);
			if (i % 7 == 0 || str.lastIndexOf("7") == str.length() - 1) {
				total += i;
				System.out.println(i);
			}
		}
		System.out.println(total);
	}

}
