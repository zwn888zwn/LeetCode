import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class _1114PrintinOrder {
    public static void main(String[] args) {
        Foo foo=new Foo();
        new Thread(()->{
            try {
                foo.first(()->System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.second(()->System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.third(()->System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class Foo {
    private ReentrantLock reentrantLock;
    private Condition condition1;
    private Condition condition2;
    private Condition condition3;
    private volatile int signal=1;

    public Foo() {
        reentrantLock = new ReentrantLock();
        condition1 = reentrantLock.newCondition();
        condition2 = reentrantLock.newCondition();
        condition3 = reentrantLock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        reentrantLock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            signal=2;
            condition2.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (signal!=2)
                condition2.await();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printSecond.run();
            signal=3;
            condition3.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (signal!=3)
                condition3.await();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printThird.run();
            condition1.signal();
        } finally {
            reentrantLock.unlock();
        }
    }
}