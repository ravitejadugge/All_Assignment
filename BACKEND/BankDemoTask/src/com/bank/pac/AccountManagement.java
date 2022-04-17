package com.bank.pac;

import  java.util.ArrayList;

public class AccountManagement  extends com.bank.pac.Account{

     ArrayList<Account> list = new ArrayList<Account>();

    void create_account(String name,long an) {
        if (isPresent(an)) {
            System.out.println("account exists");
        }
        else {
            list.add(new Account(name,0f,an));
            System.out.println(an);
        }
    }

    void deposit_amount(long accNumber,float deposit_amount ,int limit) {
        float ans = 0f;

        if(deposit_amount < 500  ) {
            System.out.println("Minimum deposit is 500");
        } else if(deposit_amount > 50000) {
            System.out.println("Maximum deposit is 50,000");
        } else if(limit >  3 ) {
            System.out.println("Only Three deposits are allowed");
        }
        else {
            if (isPresent(accNumber)) {
            for(Account i : list) {
                if(i.acc_Number == accNumber) {

                    if(i.balance+deposit_amount > 1_00_000){
                        System.out.println("Account Limit has crossed you can have only 1LAKH as Limit");
                        return;
                    } else {
                        i.balance = i.balance + deposit_amount;
                        ans = i.balance ;
                    }
                }
            }
            } else {
                System.out.println("Account not Exist..");
                return;
            }
            System.out.println(ans);
        }
    }
    void balance(long acc_id) {
        float bal = 0f;
        for (Account i : list) {
            if (i.acc_Number == acc_id) {
                bal = i.balance;
            }
        }
        System.out.println(bal);
    }
    void withdrawn_amount(long acc_number, float withdrawn_amount, int limit) {
        float res = 0f;
        if(withdrawn_amount < 1000){
            System.out.println("Minimum withdrawal amount is 1000");
        }
        else if(withdrawn_amount > 25000){
            System.out.println("Maximum withdrawal amount is 25000");
        } else if(limit >  3 ) {
            System.out.println("Only Three withdrawals are allowed");
        }
        else{
            if(isPresent(acc_number)) {
                for (Account i : list) {
                    if (i.acc_Number == acc_number && i.balance - withdrawn_amount >= 0) {
                        i.balance = i.balance - withdrawn_amount;
                        res = i.balance;
                    } else {
                        System.out.println("Balance not Enough to withdraw.");
                    }
                }
            } else { System.out.println("Account Not Present");
                return;
            }
            System.out.println(res);
        }
    }

    public boolean isPresent(long accNumber) {
        for (Account i : list) {
            if (i.acc_Number == accNumber) {
               return  true;
            }
        }
        return  false;
    }
    void amountToTransfer (long fromAccount , long toAccount , float amount) {

        if(amount <500 ) {
            System.out.println("Minimum withdrawal amount is 1000 for account "+toAccount);
        } else if(amount >= 30000) {
            System.out.println("Minimum withdrawal amount is 3000 for account "+toAccount);
        } else {
            if(isPresent(fromAccount) && isPresent(toAccount) && fromAccount != toAccount){
                for (Account i : list) {
                    if (i.acc_Number == fromAccount) {
                        i.balance = i.balance - amount;
                    }
                    if(i.acc_Number == toAccount) {
                        i.balance = i.balance + amount;
                    }
                }
                System.out.println("Success");
            } else  {
                System.out.println("Account does not Exit !.... please provide a valid AccountNumber");
            }
        }
    }


}
