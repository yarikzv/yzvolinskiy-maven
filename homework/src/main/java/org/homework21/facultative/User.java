package org.homework21.facultative;

public class User implements Runnable {
    private Terminal terminal;
    private int maxRefill;
    private int maxWithdraw;
    private int cycle;

    public User(Terminal terminal, int maxRefill, int maxWithdraw, int cycle) {
        this.terminal = terminal;
        this.maxRefill = maxRefill;
        this.maxWithdraw = maxWithdraw;
        this.cycle = cycle;
    }

    /**
     * This method calls transaction in random order using {@code Math.random()}.
     * After that it build message using {@code StringBuilder} with
     * description of transaction.
     * Synchronized for access from other threads.
     * Used {@code Thread.sleep()} for more attractive displaying of results.
     */
    public void run() {
        int i = 0;
        while (i++ < cycle) {
            try {
                if (Math.random() > 0.4) {
                    terminal.refillTransaction(maxRefill);
                } else {
                    terminal.withdrawTransaction(maxWithdraw);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            terminal.managerWakeUp();
        }
    }
}
