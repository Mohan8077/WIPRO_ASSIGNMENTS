package CCompany;

public class Tank {
    private boolean isFilled = false;
    private boolean isReleased = false;

    public void fillTank() {
        isFilled = true;
        System.out.println("Tank filled.");
    }

    public void emptyTank() {
        isFilled = false;
        System.out.println("Tank emptied.");
    }

    public void releaseTank() {
        if (isFilled) {
            System.out.println("Warning: Tank still filled. Emptying before release...");
            emptyTank();
        }
        isReleased = true;
        System.out.println("Tank released (cleaned).");
    }

    @Override
    protected void finalize() throws Throwable {
        if (!isReleased) {
            System.out.println("ERROR: Tank was not released before garbage collection!");
        } else {
            System.out.println("Tank finalized properly.");
        }
        super.finalize();
    }
}
