package org.homework21.facultative;

import java.util.Random;
import java.util.Scanner;

public class Terminal {
    private static final String LIGHT_BLUE_ITALIC = "\033[3;34;5m";
    private static final String RED_ITALIC = "\033[31;3m";
    private static final String RESET = "\033[0m";
    private int transactionCounter;
    private int accountAmount;
    private int waitingCount;

    public Terminal(int accountAmount) {
        this.accountAmount = accountAmount;
    }


    /**
     * A method for adding cash to ATM.
     */
    public synchronized void refillTransaction(int maxRefill) throws InterruptedException {
        int refillAmount = new Random().nextInt(maxRefill) + 1;
        StringBuilder message = new StringBuilder();
        message
                .append(String.format(LIGHT_BLUE_ITALIC + "[%06d]" + RESET, ++transactionCounter))
                .append(String.format(" ATM amount: %6d  ", accountAmount))
                .append("Thread: ")
                .append(LIGHT_BLUE_ITALIC)
                .append(String.format("%7s", Thread.currentThread().getName()))
                .append(RESET)
                .append(" Transaction: ")
                .append(LIGHT_BLUE_ITALIC)
                .append(String.format("%8s", "Refill"))
                .append(RESET)
                .append(" Transaction amount: ")
                .append(LIGHT_BLUE_ITALIC)
                .append(String.format("%6d", refillAmount))
                .append(RESET);
        System.out.println(message);
        accountAmount += refillAmount;
        notifyAll();
        Thread.sleep(500);
    }

    /**
     * A method for getting cash from ATM. Checks if cash amount in ATM is enough
     * for given amount. If not enough calls user input of amount from the console.
     */
    public synchronized void withdrawTransaction(int maxWithdraw) throws InterruptedException {
        int withdrawAmount = new Random().nextInt(maxWithdraw) + 1;
        while (accountAmount < withdrawAmount) {
            StringBuilder message = new StringBuilder()
                    .append(String.format(LIGHT_BLUE_ITALIC + "[%06d]" + RESET, ++transactionCounter))
                    .append(String.format(" ATM amount: %6d  ", accountAmount))
                    .append("Thread: ")
                    .append(LIGHT_BLUE_ITALIC)
                    .append(String.format("%7s", Thread.currentThread().getName()))
                    .append(RESET)
                    .append(" Transaction: ")
                    .append(LIGHT_BLUE_ITALIC)
                    .append(String.format("%8s", "Withdraw"))
                    .append(RESET)
                    .append(" Transaction amount: ")
                    .append(LIGHT_BLUE_ITALIC)
                    .append(String.format("%6d", withdrawAmount))
                    .append(RESET);
            waitingCount++;
            System.out.println(message + " ...WAITING...");
            wait();
        }
        StringBuilder message = new StringBuilder()
                .append(String.format(LIGHT_BLUE_ITALIC + "[%06d]" + RESET, ++transactionCounter))
                .append(String.format(" ATM amount: %6d  ", accountAmount))
                .append("Thread: ")
                .append(LIGHT_BLUE_ITALIC)
                .append(String.format("%7s", Thread.currentThread().getName()))
                .append(RESET)
                .append(" Transaction: ")
                .append(LIGHT_BLUE_ITALIC)
                .append(String.format("%8s", "Withdraw"))
                .append(RESET)
                .append(" Transaction amount: ")
                .append(LIGHT_BLUE_ITALIC)
                .append(String.format("%6d", withdrawAmount))
                .append(RESET);
        System.out.println(message);
        accountAmount -= withdrawAmount;
        Thread.sleep(500);
    }

    public synchronized void managerRefill() throws InterruptedException {
        while (waitingCount < Thread.activeCount() - 2){
            wait();
        }
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(500);
        System.out.print("╭" + "─".repeat(65) + "\n│ " +
                RED_ITALIC + "Not enough funds. " + RESET +
                "\uD83D\uDCB5 \n│ Current ATM amount: " +
                RED_ITALIC + accountAmount + RESET +
                "\n│ Enter the amount to refill the ATM by manager: ");
        int fill = scanner.nextInt();
        if (fill > 0) {
            accountAmount += fill;
            System.out.printf("│ ATM refilled with %d\n╰" + "─".repeat(65) + "\n", fill);
        } else {
            System.out.println("│ " + RED_ITALIC + "Wrong amount".toUpperCase() + RESET);
            System.out.println("╰" + "─".repeat(65));
        }
        notifyAll();
    }

    public synchronized void managerWakeUp() {
        if (waitingCount >= Thread.activeCount() - 2) {
            notify();
        }
    }
}
