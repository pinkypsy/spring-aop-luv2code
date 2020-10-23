package ua.alvin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class CloudLogAsyncAspect {

    @Before(" ua.alvin.aopdemo.aspect.AopExpressionPointcuts.forDaoPackageNoGetterAndSetter() ")
    public void logToCloudAsync(){
        System.out.println("\n===> CloudLogAsyncAspect");
        System.out.println("============");
    }

}
