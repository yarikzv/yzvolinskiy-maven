package org.homework21.facultative;

public class Manager implements Runnable {
    private final Terminal terminal;

    public Manager(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public void run() {
        try {
            terminal.managerRefill();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}