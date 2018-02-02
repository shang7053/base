package com.scc;

/**
 * @ClassName: AHA01
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2018年1月26日 下午4:36:42
 * 
 */
public class AHA11 {

	public static void main(String[] args) {
		long max = 0L;
		String data = "123456789";
		for (int i = 0; i < 6; i++) {
			long a = Long.valueOf(data.substring(0, i + 1));
			for (int j = 0; j < 6; j++) {
				if (i + j + 1 + 1 > data.length()) {
					continue;
				}
				long b = Long.valueOf(data.substring(i + 1, i + j + 1 + 1));
				for (int k = 0; k < 6; k++) {
					if (i + j + k + 1 + 1 + 1 > data.length()) {
						continue;
					}
					long c = Long.valueOf(data.substring(i + j + 1 + 1, i + j + k + 1 + 1 + 1));
					if (i + j + k + 1 + 1 + 1 + 1 > data.length()) {
						continue;
					}
					long d = Long.valueOf(data.substring(i + j + k + 1 + 1 + 1, data.length()));
					if (a * b * c * d > max) {
						max = a * b * c * d;
						System.out.println(max + "---" + a + "---" + b + "-----" + c + "----" + d);
					}
				}
			}
		}
	}

}
