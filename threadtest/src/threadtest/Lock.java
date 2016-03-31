/**
 * @Title: Lock.java 
 * @Package test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author shangchengcai@voole.com
 * @date 2016年3月31日 下午4:31:28   
 */
package threadtest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Lock
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年3月31日 下午4:31:28
 * 
 */
public class Lock implements Runnable {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Lock()).start();
        new Thread(new Lock()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "进入锁");
        this.lock.lock();
        System.out.println(Thread.currentThread().getName() + "获取到锁");
        System.out.println(Thread.currentThread().getName() + "获取到锁");
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;
        this.lock.unlock();
        System.out.println(Thread.currentThread().getName() + "释放锁");
    }
}
