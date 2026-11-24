/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campuswallet;

/**
 *
 * @author ethan
 */
public class CampusWallet {

    private String owner;
    private int balance;

    // Two-argument constructor
    public CampusWallet(String owner, int balance) {
        this.owner = owner;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    // One-argument constructor
    public CampusWallet(String owner) {
        this(owner, 0);
    }

    // Deposit credits
    public boolean deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    // Transfer credits to another wallet
    public boolean transferTo(CampusWallet recipient, int amount) {
        if (recipient != null && recipient != this &&
            amount > 0 && balance >= amount) {

            balance -= amount;
            recipient.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    // Get balance
    public int getBalance() {
        return balance;
    }

    // Main method
    public static void main(String[] args) {

        CampusWallet aly = new CampusWallet("Aly", 100);
        CampusWallet ben = new CampusWallet("Ben");

        // Starting balances
        System.out.println("Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        // Aly transfers 35 credits to Ben
        System.out.println(aly.transferTo(ben, 35));
        System.out.println("Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        // Aly tries to transfer 70 credits
        System.out.println(aly.transferTo(ben, 70));
        System.out.println("Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        // Aly tries to transfer to herself
        System.out.println(aly.transferTo(aly, 10));
        System.out.println("Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        // Ben deposits 15 credits
        System.out.println(ben.deposit(15));
        System.out.println("Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());

        // Aly transfers all her remaining credits to Ben
        System.out.println(aly.transferTo(ben, 65));
        System.out.println("Aly: " + aly.getBalance() + ", Ben: " + ben.getBalance());
    }
}
//ACTIVITY 3 Q&A
//Q1. What happens when a transfer is zero credits?
//The transfer returns false because the amount must be greater than zero. Neither wallet's balance changes.
//Q2. What happens when the recipient is null?
//The transfer returns false because there is no recipient wallet to receive the credits. Aly's balance stays the same, and no credits are transferred.
