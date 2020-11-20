package ThreadLearn;

import sun.security.jca.GetInstance;

public class SynchronizedTest {

    private Object lock = new Object();

    /**
     * 锁住非静态变量
     * @throws InterruptedException
     */
    public void lockObjectField() {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+"lockObjectField");
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 锁住 this 对象 this 就是当前对象实例
     * @throws InterruptedException
     */
    public void lockThis() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"lockThis");
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 直接锁住非静态方法
     * @throws InterruptedException
     */
    public synchronized void methodLock() {
        System.out.println(Thread.currentThread().getName() +"methodLock");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private volatile SynchronizedTest instance;
    /**
     * 两次判空:
     * 第一次为了存在该实例后不通过锁提高性能
     * 第二次如果不加，在二个线程同时命中判空后，第二个线程等待第一个线程释放锁后又重新创建一个对象，违背了单例原则
     *
     *volatile 作用：1.禁止指令重排序 2. 数据可见性 3.
     * 不加volatile 问题： 创建对象过程： 1.分配内存地址 2.初始化该空间 3. 将引用指向该空间地址
     * 会存在指令重排序
     * 132， 将引用指向一个未初始化完成的空间，调用会存在问题
     */

    public SynchronizedTest GetInstance(){
        if(instance == null){
            synchronized (SynchronizedTest.class){
                if(instance == null){
                    instance = new SynchronizedTest();
                }
            }
        }
       return instance;
    }

    public static void main(String[] args){
//        for (int i = 0; i < 5; i++) {
//            Thread worker = new Thread(new ObjectLockWorker());
//            worker.setName("kite-" + i);
//            worker.start();
//        }
        SynchronizedTest objectLock = new SynchronizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.lockObjectField();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.lockThis();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.methodLock();
            }
        }).start();
    }

    public static class ObjectLockWorker implements Runnable{
        @Override
        public void run() {
            try {
                SynchronizedTest objectLock = new SynchronizedTest();
                // 方式 1
                objectLock.lockObjectField();
                // 方式 2
                //objectLock.lockThis();
                // 方式 3
                //objectLock.methodLock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}