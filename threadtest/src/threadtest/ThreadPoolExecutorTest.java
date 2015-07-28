package threadtest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
		 BlockingQueue<Runnable> queue=new ArrayBlockingQueue<Runnable>(10);
		ThreadPoolExecutor tpe=new ThreadPoolExecutor(1, 10, 2000, TimeUnit.SECONDS, queue);
		tpe.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		for (int i = 0; i < 200; i++) {
			tpe.execute(new A());
		}
//		while (tpe.getActiveCount()!=0||tpe.getQueue().size()!=0) {
//			System.out.println("当前执行数"+tpe.getActiveCount()+"未处理数"+tpe.getQueue().size()+"已完成任务数"+tpe.getCompletedTaskCount());
//		}
	}
}
class A implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String aString="a";
		String aString1="a";
		String aString2="a";
		String aString3="a";
		String aString4="a";
		System.out.println(Thread.currentThread().getId());
	}
	
}
