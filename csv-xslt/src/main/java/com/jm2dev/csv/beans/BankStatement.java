package com.jm2dev.csv.beans;

import java.text.DecimalFormat;

public class BankStatement {
    private double balance;
    private String date;
    private String account;
    private double amount;
    private String subcategory;
    private String memo;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BankStatement() {
    }

    public BankStatement(double balance, String date, String account, double amount, String subcategory, String memo) {
        this.balance = balance;
        this.date = date;
        this.account = account;
        this.amount = amount;
        this.subcategory = subcategory;
        this.memo = memo;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00##");
        return df.format(balance) +
                "," + date +
                "," + account +
                "," + df.format(amount) +
                "," + subcategory +
                "," + memo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankStatement that = (BankStatement) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (Double.compare(that.balance, balance) != 0) return false;
        if (!account.equals(that.account)) return false;
        if (!date.equals(that.date)) return false;
        if (!memo.equals(that.memo)) return false;
        if (!subcategory.equals(that.subcategory)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(balance);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + date.hashCode();
        result = 31 * result + account.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + subcategory.hashCode();
        result = 31 * result + memo.hashCode();
        return result;
    }
}
