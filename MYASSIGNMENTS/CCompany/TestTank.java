package CCompany;

public class TestTank {
    public static void main(String[] args) {
        System.out.println("Scenario 1: Properly released tank");
        Tank t1 = new Tank();
        t1.fillTank();
        t1.emptyTank();
        t1.releaseTank();
        t1 = null; // Eligible for GC

        System.out.println("\nScenario 2: Tank not released properly");
        Tank t2 = new Tank();
        t2.fillTank();
        t2 = null; // Not released

        System.out.println("\nRequesting garbage collection...");
        System.gc();

        // Give time for finalize to run (not guaranteed immediately)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted.");
        }

        System.out.println("Main ended.");
    }
}