package java8study;

/**
 * 实现Runnable线程案例
 * 
 * @author Administrator
 *
 */
public class Test01 {
	/**
	 * 使用() -> {} 替代匿名类：
	 * 
	 * //Before Java 8: new Thread(new Runnable() {
	 * 
	 * @Override public void run() { System.out.println("Before Java8 "); }
	 *           }).start();
	 * 
	 *           //Java 8 way: new Thread( () -> System.out.println("In Java8!")
	 *           ).start();
	 * 
	 *           Output: too much code, for too little to do Lambda expression
	 *           rocks !! 你可以使用 下面语法实现Lambda:
	 * 
	 *           (params) -> expression (params) -> statement (params) -> {
	 *           statements }
	 * 
	 *           如果你的方法并不改变任何方法参数，比如只是输出，那么可以简写如下：
	 * 
	 *           () -> System.out.println("Hello Lambda Expressions");
	 *           如果你的方法接受两个方法参数，如下：
	 * 
	 *           (int even, int odd) -> even + odd
	 * @param args
	 */
	public static void main(String[] args) {
		Thread oldSchool = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("This is from an anonymous class.");
			}
		});
		oldSchool.start();
		Thread gaoDuanDaQiShangDangCi = new Thread(
				() -> {
					System.out
							.println("This is from an anonymous method (lambda exp).");
				});
		gaoDuanDaQiShangDangCi.start();
		Thread aa = new Thread(() -> {
			System.out.println("Test01.main()");
		});
		aa.start();
		new Thread(()->System.out.println("最简化")).start();;
	}
}
