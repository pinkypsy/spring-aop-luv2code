package ua.alvin.aopdemo;

import org.springframework.stereotype.Component;

@Component
public class FortuneTrafficService {

    public String getTraffic(){
        System.out.println("calculating...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ready!");

        return "Today gonna be a good day!";

    }

    public String getTraffic(boolean tripWire) {

        if (tripWire){
            throw new RuntimeException("Highway is closed!");
        }

        return getTraffic();
    }
}
