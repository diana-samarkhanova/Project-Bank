package org.example;

public class Database {
    public static BankAccount[] allAccounts = new BankAccount[10];
    static{
        allAccounts[0] = new CityBankAccount("Ilyas","Zhuanyshev",20000,"KZ010322312", "0102");
        allAccounts[1] = new CityBankAccount("Erbol","Assanbek",10000,"KZ010322313", "0101");
        allAccounts[2] = new CityBankAccount("Ilyas","Anibayev",25000,"KZ010322314", "1254");
        allAccounts[3] = new CityBankAccount("Damir","Iskakov",40000,"KZ010322315", "8698");
        allAccounts[4] = new CityBankAccount("Anel","Amangeldy",18000,"KZ010322316", "5683");
        allAccounts[5] = new NationalBankAccount("Amina Akanova",30000,"KZ010322317", "9503");
        allAccounts[6] = new NationalBankAccount("Tomiris Bekenova",28000,"KZ010322318", "5285");
        allAccounts[7] = new NationalBankAccount("Darkhan Zhanayev",15000,"KZ010322319", "6034");
        allAccounts[8] = new NationalBankAccount("Arystan Sultanov",40000,"KZ010322320", "7405");
        allAccounts[9] = new NationalBankAccount("Beksultan Mukashev",34000,"KZ010322321", "9021");
    }


}
