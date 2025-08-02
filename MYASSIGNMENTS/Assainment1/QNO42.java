package Assainment1;

public class QNO42 {

	

	    // This method throws an exception initially
	    public static void someMethod2() throws Exception {
	        throw new Exception("Exception thrown from someMethod2");
	    }

	    // This method calls someMethod2, catches the exception, then rethrows it
	    public static void someMethod() throws Exception {
	        try {
	            someMethod2();
	        } catch (Exception e) {
	            System.out.println("Caught exception in someMethod, rethrowing...");
	            throw e;  // Rethrow the caught exception
	        }
	    }

	    // main method calls someMethod and catches the rethrown exception
	    public static void main(String[] args) {
	        try {
	            someMethod();
	        } catch (Exception e) {
	            System.out.println("Caught rethrown exception in main:");
	            e.printStackTrace();  // Print stack trace
	        }
	    }
	

}