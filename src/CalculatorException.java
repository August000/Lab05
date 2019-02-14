/**
 * Exception class for representing exceptions that can
 * occur within a Calculator. Calculator exceptions have
 * a message that is passe to the super constructor.
 *
 * This class is very simple. There's not much to it, but it allows the program to throw very specific exceptions.
 * When a CalculatorException is thrown and caught, we know that the cause for the error is something specific to the
 * calculator - not just some general error like a NullPointerException. This allows the program to react accordingly.
 * If a CalculatorException is thrown, it means that there's an issue with the user input. When caught, this feedback
 * can be given to the user. If we only checked to see if any error had occurred, we wouldn't know what the root cause
 * was, and couldn't give meaningful feedback to the user.
 *
 * @author Stephen
 * @version 2018-09-23
 */
public class CalculatorException extends Exception
{
    /**
     * Added to disable warnings.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Sets the message and type. Uses super constructor to set the message.
     *
     * @param message The message of the Calculator Exception. Should be "Illegal Token Length"
     * or "Illegal Command".
     */
    public CalculatorException(String message)
    {
        super(message);
    }
}