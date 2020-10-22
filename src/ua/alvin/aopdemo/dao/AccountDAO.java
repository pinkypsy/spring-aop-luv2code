package ua.alvin.aopdemo.dao;

import org.springframework.stereotype.Component;
import ua.alvin.aopdemo.Account;

@Component
public class AccountDAO {


    private String name;


    public void addAccount(Account account, boolean b){
        System.out.println(getClass() + " Doing my DB work addAccount()\n");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass() + " names has been stated");
    }


}
