package test;

public class Test {
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		testtotal();
		System.out.println(System.currentTimeMillis()-start);
		long start1=System.currentTimeMillis();
		testother();
		System.out.println(System.currentTimeMillis()-start1);
	}

	private static void testother() {
		Persion p=new Persion();
		for (int i = 0; i < 200000; i++) {
			for (int j = 0; j < 200; j++) {
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
			}
		}
		for (int i = 200000; i < 400000; i++) {
			for (int j = 0; j < 200; j++) {
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
			}
		}
		for (int i = 400000; i < 600000; i++) {
			for (int j = 0; j < 200; j++) {
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
			}
		}
	}

	private static void testtotal() {
		Persion p=new Persion();
		for (int i = 0; i < 600000; i++) {
			for (int j = 0; j < 200; j++) {
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
				p.setId(j);
			}
		}
	}
}
