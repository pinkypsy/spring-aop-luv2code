package ua.alvin.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.alvin.aopdemo.dao.AccountDAO;
import ua.alvin.config.ConfigAop;

import java.util.List;
import java.util.logging.Logger;

public class MainAppForAroundAdvice {
    
    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigAop.class);

        System.out.println("MainAppForAroundAdvice:");


        FortuneTrafficService fortuneTrafficService = context.getBean(FortuneTrafficService.class);

//        System.out.println(fortuneTrafficService.getTraffic());
        System.out.println(fortuneTrafficService.getTraffic(false));

        context.close();
    }

}
