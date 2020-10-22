package ua.alvin.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class ManagerDAO  {

    private String name;

    public boolean addAccount(){
        System.out.println(getClass() + " Doing my DB work addAccount()");
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass() + " names has been stated");
    }


}
