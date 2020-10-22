package ua.alvin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.alvin.aopdemo.dao.AccountDAO;
import ua.alvin.config.ConfigAop;

import java.util.List;

public class MainAppForAfterReturning {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAop.class);

        System.out.println("MainAppForAfterReturning:");

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = accountDAO.findAccounts();

        System.out.println("accountList in AfterReturningAdvice " + accountList);

        context.close();
    }

}
