package ua.alvin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.alvin.aopdemo.dao.AccountDAO;
import ua.alvin.aopdemo.dao.ManagerDAO;
import ua.alvin.config.ConfigAop;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAop.class);


        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        ManagerDAO managerDAO = context.getBean("managerDAO", ManagerDAO.class);
        accountDAO.setName("account name");
        managerDAO.setName("manager name");

        System.out.println(accountDAO.getName());
        System.out.println(managerDAO.getName());

        accountDAO.addAccount(new Account(), true);
        managerDAO.addAccount();

        context.close();
    }

}
