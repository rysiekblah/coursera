package com.kozlowst.thlocal;

/**
 * Created by tomek on 10/18/14.
 */
public class NotThreadLocal {

    public static class Local {
        Context ctx;

        public Context get() {
            return ctx;
        }

        public void set(Context ctx) {
            this.ctx = ctx;
        }

        public void remove() {

        }
    }

    private static Local local = new Local();

    public static void set(Context ctx) {
        local.set(ctx);
    }

    public static void unset() {
        local.remove();
    }

    public static Context get() {
        return local.get();
    }

}
