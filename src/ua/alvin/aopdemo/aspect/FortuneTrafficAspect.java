package ua.alvin.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class FortuneTrafficAspect {

    Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* ua.alvin.aopdemo.FortuneTrafficService.getTraffic(..) )")
    public Object aroundGetFortuneTrafficAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("===> Running @Around aspect\n");
        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            result = "No riding today because: " + throwable.toString();
//            myLogger.warning(throwable.toString());
//            throw throwable;
        }

        System.out.println("\n===> Get back to @Around aspect");
        long end = System.currentTimeMillis();

        System.out.println("\nDuration: " + (end - begin) + " ms.");

        return result;
    }

}
