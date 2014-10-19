package com.kozlowst.thlocal;

/**
 * Created by tomek on 10/18/14.
 */
public class MyThreadLocal {

    public static final ThreadLocal<Context> userThreadLocal = new ThreadLocal();

    public static void set(Context ctx) {
        userThreadLocal.set(ctx);
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static Context get() {
        return userThreadLocal.get();
    }

}
