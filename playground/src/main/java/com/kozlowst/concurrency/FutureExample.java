package com.kozlowst.concurrency;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by tomek on 10/22/14.
 */
public class FutureExample {

    private static class Task implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            long val = 0;
            for (int i = 0; i < 10000; i++) {
                val = i * i;
            }
            return val;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Long> f = executorService.submit(new Task());
            System.out.println("Future:: cancled: " + f.isCancelled() + ", done: " + f.isDone());
            futureList.add(f);
            if (i % 2 == 0) {
                f.cancel(true);
            }
        }
        long sum = 0;
        for (Future<Long> longFuture : futureList) {
            System.out.println("canceled: " + longFuture.isCancelled() + ", done: " + longFuture.isDone());
            try {
                sum += longFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("SUM: " + sum);

    }

}
