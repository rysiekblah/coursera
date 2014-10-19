package com.kozlowst.thlocal;

/**
 * Created by tomek on 10/18/14.
 */
public class BusinessService {

    public void businesMethod() {
        Context ctx = MyThreadLocal.get();
        Context ctx1 = NotThreadLocal.get();
        System.out.println(ctx.getTransactionId() + ", " + ctx1.getTransactionId());
    }

}
