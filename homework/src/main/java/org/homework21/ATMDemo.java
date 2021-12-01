package org.homework21;

public class ATMDemo {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Runnable doOperations = atm::operations;

        // Creating three threads for emulating three users' access to ATM.
        Thread mother = new Thread(doOperations, "Mother");
        Thread father = new Thread(doOperations, "Father");
        Thread son = new Thread(doOperations, "Son");

        // Threads starting
        mother.start();
        father.start();
        son.start();
    }
}
