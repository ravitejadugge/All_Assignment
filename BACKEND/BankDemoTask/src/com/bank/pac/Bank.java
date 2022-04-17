package com.bank.pac;
import  java.util.Scanner;
public class Bank extends Driver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank obj = new Bank();
        String Case = "";
        while (Case != "exit") {
            Case = input.next().toLowerCase();
            obj.switchCase(Case);
        }
    }
}
