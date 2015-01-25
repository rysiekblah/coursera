package com.kozlowst.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by tomek on 11/23/14.
 */
public class ForkJoin {

    private static class Problem {
        private final int[] list = new int[2000000];

        public Problem() {
            Random generator = new Random(19580427);
            for (int i = 0; i < list.length; i++) {
                list[i] = generator.nextInt(500000);
            }
        }

        public int[] getList() {
            return list;
        }
    }

    private static class Solver extends RecursiveAction {

        private int[] list;
        public long result;

        public Solver(int[] array) {
            list = array;
        }

        @Override
        protected void compute() {
            if (list.length == 1) {
                result = list[0];
            } else {
                int mid = list.length / 2;
                int[] l1 = Arrays.copyOfRange(list, 0, mid);
                int[] l2 = Arrays.copyOfRange(list, mid, list.length);
                Solver s1 = new Solver(l1);
                Solver s2 = new Solver(l2);
                invokeAll(s1, s2);
                result = s1.result + s2.result;
            }
        }
    }

    private static class TimeMeter {
        private long timestamp;

        public TimeMeter() {
            this.timestamp = System.currentTimeMillis();
        }

        public long get() {
            return System.currentTimeMillis() - timestamp;
        }
    }

    private static long calcNormal(int[] list) {
        long result = 0;
        for (int i = 0; i < list.length; i++) {
            result +=list[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Problem test = new Problem();
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("num of processors: " + nThreads);
        Solver solver = new Solver(test.getList());
        ForkJoinPool pool = new ForkJoinPool(nThreads);
        TimeMeter t1 = new TimeMeter();
        pool.invoke(solver);
        System.out.println("Result: " + solver.result + ", time: " + t1.get());
        TimeMeter t2 = new TimeMeter();
        long res = calcNormal(test.getList());
        System.out.println("Result: " + res + ", time: " + t2.get());
    }
}
