package org.autumn.revolution.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;

/**
 * Created by yangzhic on 2016/8/8.
 */
public class SimpleProfiler implements Ordered{

    private int order;

    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order){
        this.order = order;
    }

    public Object profile(ProceedingJoinPoint call) throws Throwable {
        Object returnValue;
        StopWatch clock = new StopWatch(getClass().getName());
        try {
            clock.start(call.toShortString());
            returnValue = call.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
        return returnValue;
    }


}
