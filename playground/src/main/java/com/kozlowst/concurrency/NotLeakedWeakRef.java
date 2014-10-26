package com.kozlowst.concurrency;


/**
 * Created by tomek on 10/22/14.
 */
public class NotLeakedWeakRef {

    private String name;
    private Worker worker;

    NotLeakedWeakRef(String name) {
        this.name = name;
    }

    public void go() {
        System.out.println("Start " + name);
//        WeakReference<Worker> w = new WeakReference<>(new Worker());
//        w.get().start();
        worker = new Worker();
        worker.start();
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < 10) {
                try {
                    Thread.sleep(50);
                    //System.out.println("Leaked i="+i);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            worker = null;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize weak not leaked object " + name);
    }

}
