package com.kozlowst.concurrency;

import java.util.concurrent.*;

/**
 * Created by tomek on 10/19/14.
 */
public class ThreadDeadLock {

    //static ExecutorService exec = Executors.newFixedThreadPool(2);
    static ExecutorService exec = Executors.newSingleThreadExecutor();

    private static class RenderPageTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header", 0));
            footer = exec.submit(new LoadFileTask("footer", 0));
            return header.get() + renderBody() + footer.get();
        }

        private String renderBody() {
            return "<body>";
        }
    }

    private static class LoadFileTask implements Callable<String> {

        private String fileName;
        private int delay;

        private LoadFileTask(String fileName, int delay) {
            this.fileName = fileName;
            this.delay = delay;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(delay);
            return "<"+fileName+">";
        }
    }

    public static void main(String[] args) {
        RenderPageTask task = new RenderPageTask();
        Future<String> page = exec.submit(task);
        try {
            System.out.println(page.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.err.println("Timeout, deadlock.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }

}
