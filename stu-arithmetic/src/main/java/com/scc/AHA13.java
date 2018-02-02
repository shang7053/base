package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA13 {

	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			String data = String.valueOf(i);
			int a = Integer.valueOf(data.substring(0, 1));
			int b = Integer.valueOf(data.substring(1, 2));
			int c = Integer.valueOf(data.substring(2, 3));
			if (a * 122 + 212 * b + 221 * c == 2012) {
				System.out.println(i);
				break;
			}
		}
	}

}
