package com.kozlowst.thlocal;

/**
 * Created by tomek on 10/18/14.
 */
public class ThreadLocalDemo extends Thread {

    public static void main(String[] args) {
        Thread th1 = new ThreadLocalDemo();
        Thread th2 = new ThreadLocalDemo();

        th1.start();
        th2.start();
    }

    @Override
    public void run() {
        Context ctx = new Context();
        ctx.setTransactionId(getName());
        MyThreadLocal.set(ctx);
        NotThreadLocal.set(ctx);
        new BusinessService().businesMethod();
        MyThreadLocal.unset();
    }
}
