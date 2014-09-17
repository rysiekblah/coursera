package com.kozlowst.week1;

/**
 * Created by tomek on 9/13/14.
 */
public class Calculation {
    public static void main(String[] args) {

        int N = 20;
        fun4(2);
        fun4(3);
        fun4(5);
        fun4(10);
        fun4(20);
        fun4(30);
        fun4(40);

    }

    public static void fun1(int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                System.out.println("i= " + i + ", j= " + j);
                count++;
            }
        }
        System.out.println("cnt: " + count);
    }

    public static void fun2(int N) {
        int count = 0;
        for (int i = 1; i < N; i=i*2) {
            System.out.println("i= " + i);
            count++;
        }
        System.out.println("cnt: " + count);
    }

    public static void fun3(int N) {
        int count = 0;
        for (int i = 1; i*i < N; i++) {
            count++;
        }
        System.out.println(count);
    }

    public static void fun4(int N) {
        int sum = 0;
        for (int i = 0; i < N; i++)
            for (int j = 1; j <= N*N; j = j*2)
                sum++;
        System.out.println("N= " + N + " , " + sum + ",, " + N*Math.log(N*N)/Math.log(2));
    }



}
