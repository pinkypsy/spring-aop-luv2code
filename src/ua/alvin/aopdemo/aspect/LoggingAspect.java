package ua.alvin.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ua.alvin.aopdemo.Account;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before(" ua.alvin.aopdemo.aspect.AopExpressionPointcuts.forDaoPackageNoGetterAndSetter() ")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n===> LoggingAspect");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("methodSignature: " + methodSignature);

        System.out.println("Target: " + joinPoint.getTarget());

        Object [] methodArgs = joinPoint.getArgs();

        for (Object o :
                methodArgs) {
            System.out.println("Method arg: " + o);
            if (o instanceof Account){
                Account account = (Account) o;
                account.setName("Vova");
                System.out.println("Name is: " + account.getName());
            }
        }
    }

    @AfterReturning(pointcut = "execution( * ua.alvin.aopdemo.dao.AccountDAO.findAccounts(..) )",
    returning = "resultList")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> resultList){
        System.out.println("\n===> AfterLoggingAspect");
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> executing @AfterReturning on method: " + method);
        System.out.println("\n===> resultList is: " + resultList);

        convertAccountNamesToUppercase(resultList);

        System.out.println("\n===> resultList after modification is: " + resultList);
        System.out.println("============");
    }

    @AfterThrowing(pointcut = "execution( * ua.alvin.aopdemo.dao.AccountDAO.findAccounts(..) )",
    throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc){
        System.out.println("\n===> AfterLoggingAspect");
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> executing @AfterThrowing on method: " + method);
        System.out.println("\n===> The exception is: " + exc);
        System.out.println("============");
    }

    @After("execution( * ua.alvin.aopdemo.dao.AccountDAO.findAccounts(..) )")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        System.out.println("\n===> AfterLoggingAspect");
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> executing @After (FINALLY) on method: " + method);
        System.out.println("============");
    }

    private void convertAccountNamesToUppercase(List<Account> resultList) {
        for (Account account:
             resultList) {
            account.setName(account.getName().toUpperCase());
        }
    }

}
