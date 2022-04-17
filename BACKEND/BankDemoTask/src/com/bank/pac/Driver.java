package com.bank.pac;
import java.util.Scanner;
public class Driver extends  AccountManagement{
    static  long a = 1000;
    static  int limit = 1 ;

    void switchCase(String Case) {
        Scanner input = new Scanner(System.in);
        switch (Case) {
            case "create":
                String user_name = input.next();
                a = a + 1;
                create_account(user_name, a);
                break;
            case "deposit":
                long accNumber = input.nextLong();
                float user_amount = input.nextFloat();
                deposit_amount(accNumber, user_amount, limit);
                limit = limit + 1;
                break;
            case "balance":
                long acc_id = input.nextLong();
                balance(acc_id);
                break;
            case "withdraw":
                long acid = input.nextLong();
                user_amount = input.nextFloat();
                withdrawn_amount(acid, user_amount, limit);
                limit = limit + 1;
                break;
            case "transfer" :
                long fromAccountNumber = input.nextLong();
                long toAccountNumber = input.nextLong();
                float amount = input.nextFloat();
                amountToTransfer(fromAccountNumber,toAccountNumber,amount);
                break;
            case "exit":
                System.exit(0);
                break;
            default:

        }
    }

}
