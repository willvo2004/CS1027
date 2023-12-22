
import java.io.*;

/**
 * Class FibonacciDemo demonstrates iterative vs recursive methods that
 * return the nth Fibonacci number. 
 * @author CS1027a
 */
public class FibonacciDemo {

    // Counts the number of calls to a given method
    private static long methodCalls;

    /** Method to calculate the nth Fibonacci number recursively.
     * @param n an integer >= 1
     * @return nth Fibonacci number
     * precondition: n >= 1
     */
    public static long rfib(long n) {

        methodCalls++;

        if ((n == 1) || (n == 2)) {
            return 1;
        } else {
            return rfib(n - 1) + rfib(n - 2);
        }
    }

    /** Method to calculate the nth Fibonacci number iteratively.
     * @param n
     * @return nth Fibonacci number
     * precondition: n >= 1
     */
    public static long ifib(long n) {

        methodCalls++;

        if ((n == 1) || (n == 2)) {
            return 1;
        } else {
            long prev = 1, current = 1, next = 0;
            for (long i = 3; i <= n; i++) {
                next = prev + current;
                prev = current;
                current = next;
            }
            return next;
        }
    }

    /** Main method to call the recursive and iterative Fibonacci
     * methods.
     */
    public static void main(String args[]) throws Exception {

        long startTime;     // The start time of a method call
        long elapsed;       // The execution time of a method call
        long n;             // The Fibonacci number to compute

        System.out.println("Enter an integer n (enter the number 0 to quit): ");

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in), 1);
        System.out.print("Enter an integer: ");
        n = Integer.parseInt(keyboard.readLine());

        while (n > 0) {

            // Call the iterative Fibonacci method and measure the elapsed time and
            // the number of method calls
            methodCalls = 0;
            startTime = System.currentTimeMillis();
            System.out.println("\nIterative Fibonacci: the "+n+"-th Fibonacci number is " + ifib(n));
            elapsed = (System.currentTimeMillis() - startTime);
            System.out.println("Elapsed time: " + elapsed + "ms; number of calls to the algorithm: " + methodCalls);

            // Call the recursive Fibonacci method and measure the elapsed time and
            // the number of method calls
            methodCalls = 0;
            startTime = System.currentTimeMillis();
            System.out.println("Recursive Fibonacci: the "+n+"-th Fibonacci number is "+rfib(n));
            elapsed = (System.currentTimeMillis() - startTime);
            System.out.println("Elapsed time: " + elapsed + "ms; number of calls to the algorithm: " + methodCalls);

            System.out.print("\nEnter an integer: ");
            n = Integer.parseInt(keyboard.readLine());
        }

        System.out.println("End of program");
    }
}