package com.bank.pac;

public class Account {
        String name;
        float balance;
        long acc_Number;
        Account(){
        }
        Account(String name,float balance,long acc_Number) {
            this.name = name;
            this.balance = balance;
            this.acc_Number = acc_Number;
        }
}
