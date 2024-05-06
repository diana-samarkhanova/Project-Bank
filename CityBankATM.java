package org.example;
import java.util.Scanner;
public class CityBankATM {
    public static void menu() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter account number: ");
        String enteredAccNum = in.next();

        System.out.println("Enter PIN: ");
        String enteredPinCode = in.next();

        BankAccount account = findAcc(enteredAccNum, enteredPinCode);
        if (account instanceof CityBankAccount){
            FullMenu(in, (CityBankAccount) account);
        } else if (account instanceof NationalBankAccount){
            ShortMenu(in, (NationalBankAccount) account);
        } else {
            System.out.println("Account not found");

        }

    }
    public static BankAccount findAcc(String inaccNum, String inpin) {
        for (BankAccount acc : Database.allAccounts){
            if( acc!= null && acc.getAccountNumber().equals(inaccNum)&& acc.getPinCode().equals(inpin)){

                return acc;
            }
        }

        return null;
    }

    public static void FullMenu(Scanner in, CityBankAccount account) {
        while(true){

            System.out.println("PRESS [1] TO CASH WITHDRAWAL");
            System.out.println("PRESS [2] TO VIEW BALANCE");
            System.out.println("PRESS [3] TO CHANGE PIN CODE");
            System.out.println("PRESS [4] TO CASH IN ACCOUNT");
            System.out.println("PRESS [5] TO VIEW ACCOUNT DATA");
            System.out.println("PRESS [6] TO EXIT");

            int choice = in.nextInt();

            if(choice == 1 ){
                cashWithdrawal(in, account);
            }
            if(choice == 2) {
                viewBalance(account);
            }
            if(choice == 3){
                changePin(in, account);
            }
            if(choice == 4){
                cashInAccount(in, account);
            }
            if(choice == 5){
                viewAccountData(account);
            }
            if(choice == 6){
                System.exit(0);
            }
        }

    }
    public static void ShortMenu(Scanner in, NationalBankAccount account) {
        while(true) {
            System.out.println("PRESS [1] TO CASH WITHDRAWAL");
            System.out.println("PRESS [2] TO VIEW BALANCE");
            System.out.println("PRESS [3] TO EXIT");

            int choice = in.nextInt();

            if(choice == 1 ){
                cashWithdrawal(in, account);
            }
            if(choice == 2) {
                viewBalance(account);
            }

            if(choice == 3){
                System.exit(0);
            }
        }

    }
    public static void cashWithdrawal(Scanner in, BankAccount account){
        System.out.println("Enter withdrawal sum: ");
        int sum = in.nextInt();
        if (account instanceof  CityBankAccount) {
            CityBankAccount cityAcc = (CityBankAccount) account;
            if (cityAcc.totalBalance() >= sum){
                cityAcc.creditBalance(sum);
                System.out.println("Successful cash withdrawal. New balance: " + account.totalBalance());
            } else {
                System.out.println("Insufficient funds");
            }
        } else if (account instanceof NationalBankAccount) {
            NationalBankAccount natAcc = (NationalBankAccount) account;
            int totalsum = sum + 200;
            if(natAcc.totalBalance() >= totalsum) {
                natAcc.creditBalance(sum);
                System.out.println("Successful cash withdrawal. Commission is 200 tg. New balance: " + account.totalBalance());
            } else {
                System.out.println("Insufficient funds");
            }
        } else {
            System.out.println("Failed");
        }
    }
    public static void viewBalance(BankAccount account){
        System.out.println("Balance: " + account.totalBalance());

    }
    public static void changePin(Scanner in, CityBankAccount account){
        System.out.println("Enter  new PIN: ");
        String newPIN = in.next();
        account.setPinCode(newPIN);
        System.out.println("PIN code changed.");

    }
    public static void cashInAccount(Scanner in, CityBankAccount account) {
        System.out.println("Enter sum of CASH-IN: ");
        int cashin = in.nextInt();
        account.debitBalance(cashin);
        System.out.println("CASH-IN was successful. New balance: " + account.totalBalance());

    }
    public static void viewAccountData(CityBankAccount account) {
        System.out.println(account.accountData());

    }
    public static void exit(){

    }

}
