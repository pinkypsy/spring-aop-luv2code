package ua.alvin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ApiAnalyticsAspect {

    @Before(" ua.alvin.aopdemo.aspect.AopExpressionPointcuts.forDaoPackageNoGetterAndSetter() ")
    public void performingAnalyticsAdvice(){
        System.out.println("\n===> ApiAnalyticsAspect");
    }

}
