/**
 * This class represents a custom exception that is thrown when a solution is not found.
 * It extends the standard Java Exception class.
 */
public class SolutionNotFound extends Exception {

    /**
     * Constructs a new SolutionNotFound exception with the specified detail message.
     * This message parameter is passed to the constructor of Exception.
     * @param m the detail message.
     */
    public SolutionNotFound (String m) {
        super(m);
    }
}
