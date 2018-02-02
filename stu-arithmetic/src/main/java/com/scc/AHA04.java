package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA04 {

	public static void main(String[] args) {
		int a = 0, b = 0;
		for (int i = 0; i < 45; i++) {
			if (i == 0) {
				a = 1;
				continue;
			}
			if (i == 1) {
				b = 1;
				continue;
			}
			int tmp = b;
			b = a + b;
			a = tmp;
		}
		System.out.println(b);
	}

}
