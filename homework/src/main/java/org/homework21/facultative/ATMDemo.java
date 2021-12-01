package org.homework21.facultative;

public class ATMDemo {
    public static void main(String[] args) {
        Terminal terminal = new Terminal(100);
        User ops = new User(terminal,500,1000,20);
        Manager manOps = new Manager(terminal);

        // Creating three threads for emulating three users' access to ATM.
        Thread mother = new Thread(ops, "Mother");
        Thread father = new Thread(ops, "Father");
        Thread son = new Thread(ops, "Son");
        Thread manager = new Thread(manOps, "Manager");

        // Threads starting
        mother.start();
        father.start();
        son.start();
        manager.start();

        try {
            mother.join();
            father.join();
            son.join();
            manager.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
