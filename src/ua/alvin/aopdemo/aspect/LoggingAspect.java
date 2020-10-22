package ua.alvin.aopdemo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before(" ua.alvin.aopdemo.aspect.AopExpressionPointcuts.forDaoPackageNoGetterAndSetter() ")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===> LoggingAspect");
    }

}
