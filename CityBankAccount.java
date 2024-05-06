package org.example;

 class CityBankAccount implements BankAccount{
    String name;
    String surname;
    int balance;
    String accountNumber;
    String pinCode;

    CityBankAccount(){};

    public CityBankAccount(String name, String surname, int balance, String accountNumber, String pinCode) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getPinCode() {
        return pinCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public int totalBalance() {
        return balance;
    }

    @Override
    public void creditBalance(int credit) {
        if (balance >= credit) {
            balance -= credit;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void debitBalance(int debit) {
        balance += debit;
    }

    @Override
    public String accountData() {
        return "Full name: " + name + " " + surname + "\nAccount Number: " + accountNumber + "\nBalance: " + balance;
    }
}
