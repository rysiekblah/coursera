package com.kozlowst.concurrency;

/**
 * Created by tomek on 10/22/14.
 */
class Leaked {

    private String name;

    Leaked(String name) {
        this.name = name;
    }

    public void go() {
        System.out.println("Start " + name);
        Worker w = new Worker();
        w.start();
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
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize leaked object " + name);
    }
}