package com.kozlowst.concurrency;

import java.lang.ref.WeakReference;

/**
 * Created by tomek on 10/22/14.
 */
public class Leak {
    public static void main(String[] args) {
        final Leaked leaked = new Leaked("Normal");
        leaked.go();

        final NotLeaked notLeaked = new NotLeaked("Normal");
        notLeaked.go();
        //notLeaked=null;

        final NotLeakedWeakRef notLeakedWeak = new NotLeakedWeakRef("WeakNotLeak");
        notLeakedWeak.go();


        final WeakReference<Leaked> ref = new WeakReference<>(new Leaked("Weak"));
        ref.get().go();

        final WeakReference<NotLeaked> ref2 = new WeakReference<>(new NotLeaked("Weak"));
        ref2.get().go();


        //System.gc();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        //System.out.println("weak ref: " + ref.get() + ", notleakweak: " + ref2.get());
                        System.gc();
                        System.out.printf(".");
                        if (ref.get() == null && ref2.get() == null && leaked == null && notLeaked == null && notLeakedWeak == null) {
                            System.out.println("End");
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
