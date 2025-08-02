package Assainment1;
class Worker {
    protected String name;
    protected double salaryRate;

    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public double pay(int hours) {
        return 0; 
    }

    public void displayPay(int hours) {
        System.out.println("Name: " + name + ", Pay: " + pay(hours));
    }
}

class DailyWorker extends Worker {

    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int hours) {
        int days = hours / 8;
        return days * salaryRate;
    }
}

class SalariedWorker extends Worker {

    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double pay(int hours) {
        return 40 * salaryRate; 
    }
}
public class Que13 
{
	public static void main(String[] args) {
        DailyWorker dw = new DailyWorker("John", 500);
        SalariedWorker sw = new SalariedWorker("Emma", 800);

        System.out.println("Pay Calculation:");
        dw.displayPay(48);  
        sw.displayPay(35);  
    }
}
