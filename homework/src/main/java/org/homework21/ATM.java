package org.homework21;

import java.util.Random;
import java.util.Scanner;

public class ATM {
    // Add color for more attractive displaying of output information
    private static final String LIGHT_BLUE_ITALIC = "\033[3;34;5m";
    private static final String RED_ITALIC = "\033[31;3m";
    private static final String RESET = "\033[0m";

    private int cashAmountATM;
    // Add transactions counter for transaction identification
    private int transactionCounter;

    /**
     * This method calls transaction in random order using {@code Math.random()}.
     * After that it build message using {@code StringBuilder} with
     * description of transaction.
     * Synchronized for access from other threads.
     * Used {@code Thread.sleep()} for more attractive displaying of results.
     */
    public void operations() {
        while (true) {
            StringBuilder message = new StringBuilder();
            synchronized (this) {
                System.out.printf(LIGHT_BLUE_ITALIC + "Transaction [%06d]%n" + RESET, ++transactionCounter);
                message
                        .append("Thread: ")
                        .append(LIGHT_BLUE_ITALIC)
                        .append(Thread.currentThread().getName())
                        .append(RESET);
                if (Math.random() > 0.4) {
                    message.append(refillTransaction());
                } else {
                    message.append(withdrawTransaction());
                }
                System.out.println(message);
                System.out.println("* ATM amount: " + cashAmountATM);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * A method for adding cash to ATM.
     *
     * @return String with transaction name and refill amount for building message
     * in {@code operations()} method.
     */
    private String refillTransaction() {
        int refillAmount = new Random().nextInt(9_999) + 1;
        cashAmountATM += refillAmount;
        return " >> Transaction: " +
                LIGHT_BLUE_ITALIC +
                "Refill" +
                RESET +
                " >> Transaction amount: " +
                LIGHT_BLUE_ITALIC +
                refillAmount +
                RESET;
    }

    /**
     * A method for getting cash from ATM. Checks if cash amount in ATM is enough
     * for given amount. If not enough calls user input of amount from the console.
     *
     * @return String with transaction name and withdraw amount for building message
     * in {@code operations()} method.
     */
    private String withdrawTransaction() {
        Scanner scanner = new Scanner(System.in);
        int withdrawAmount = new Random().nextInt(9_999) + 1;
        while (cashAmountATM < withdrawAmount) {
            System.out.print("╭" + "─".repeat(65) + "\n│ " +
                    RED_ITALIC + "Not enough funds. " + RESET +
                    "\uD83D\uDCB5 \n│ Current ATM amount: " +
                    RED_ITALIC + cashAmountATM + RESET +
                    "\n│ You want to withdraw: " +
                    LIGHT_BLUE_ITALIC + withdrawAmount + RESET +
                    "\n│ Enter the amount to refill the ATM: ");
            int fill = scanner.nextInt();
            if (fill > 0) {
                cashAmountATM += fill;
                System.out.printf("│ ATM refilled with %d\n╰" + "─".repeat(65) + "\n", fill);
            } else {
                System.out.println("│ " + RED_ITALIC + "Wrong amount".toUpperCase() + RESET);
                System.out.println("╰" + "─".repeat(65));
            }
        }
        cashAmountATM -= withdrawAmount;
        return " >> Transaction: " +
                LIGHT_BLUE_ITALIC +
                "Withdraw " +
                RESET +
                ">> Transaction amount: " +
                LIGHT_BLUE_ITALIC +
                withdrawAmount +
                RESET;
    }
}
