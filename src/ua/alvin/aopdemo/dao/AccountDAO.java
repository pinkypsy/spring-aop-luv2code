package ua.alvin.aopdemo.dao;

import org.springframework.stereotype.Component;
import ua.alvin.aopdemo.Account;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class AccountDAO {


    private String name;


    public void addAccount(Account account, boolean b) throws Exception {
        System.out.println(getClass() + " Doing my DB work addAccount()\n");

    }

    public ArrayList<Account> findAccounts(boolean flagForException) {

        if (flagForException){
            throw new RuntimeException();
        }

        Account account1 = new Account("John", 18);
        Account account2 = new Account("Liza", 19);
        Account account3 = new Account("Bob", 40);

        return new ArrayList<>(Arrays.asList(account1, account2, account3));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass() + " names has been stated");
    }


}
