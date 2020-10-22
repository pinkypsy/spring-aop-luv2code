package ua.alvin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopExpressionPointcuts {

    @Pointcut("execution ( * ua.alvin.aopdemo.dao.*.*(..))")
    public void aspectsForDaoPackage(){}

    @Pointcut("execution ( * ua.alvin.aopdemo.dao.*.get*() )")
    public void getter(){}

    @Pointcut("execution ( * ua.alvin.aopdemo.dao.*.set*(*) )")
    public void setter(){}

    @Pointcut("aspectsForDaoPackage() && !( getter() || setter() ))")
    public void forDaoPackageNoGetterAndSetter(){}
}
