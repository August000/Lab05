/**
 * A class representing a simple calculator. The calculator takes in an input string and interprets it as a command.
 * The calculator evaluates the command and returns a result.
 *
 * @author Stephen Thung
 * @version 2019-02-13
 */

public class Calculator
{
    /**
     * Takes an input command of two string tokens and simulates a calculator command.
     * The token length should never be something either than 2. If it is, there is an issue in execute().
     * The input expects the two tokens formatted in a String array in the form of [command, number].
     * Valid commands are "negate" and "halve". Each command takes an int value as a parameter.
     *  e.g. "negate 5" passed in as an array ["negate", "5"] returns a result of -5
     *       "halve 6" passed in as an array ["halve", "6"] returns a result of 3
     *
     * If the input is invalid, exceptions will be thrown with the following precedence:
     * (0) NumberFormatException
     *      The input number is not an int: look at Integer.parseInt. This exception is thrown automatically if the
     *      string that you try and parse is not an int value). I.e. you do not need to explicitly throw this
     *      exception.
     * (1) CalculatorException("Illegal Command")
     *      The input command is neither negate or halve. You must throw this exception explicitly. The
     *      line will look similar to "throw new CalculatorException(<<message>>);"
     *
     * @param tokens The input string to the program tokenized (split up). Should be a String array of two elements:
     *  [command, number].
     * @return The result of the calculator operation ("negate number" or "halve number"). The halved number should
     * be rounded down (i.e. the default when doing int math).
     * @throws NumberFormatException Thrown if the second token is not convertible from String to int.
     * @throws CalculatorException Thrown if the first token is not a valid command ("negate" or "halve")
     */
    protected static int calculateTwoTokens(String[] tokens) throws NumberFormatException, CalculatorException
    {
        int a = Integer.parseInt(tokens[1]); // Throws NumberFormatException if the second token is not an int value.
        // TODO: complete this...
    }

    /**
     * Takes an input command of three string tokens and performs the appropriate calculator command.
     * The token length should never be something other than 3. If it is, there is an issue in execute().
     * The input expects the three tokens formatted in a String array in the form of [num1, command, num2].
     * Valid commands are (numbers must be int values):
     *  "num1 + num2" => return num1 + num2
     *  "num1 - num2" => return num1 - num2
     *  "num1 / num2" => return num1 / num2
     *
     * If the input is invalid, exceptions will be thrown with the following precedence:
     * (0) NumberFormatException
     *      Either input number is not an int: look at Integer.parseInt. This exception is thrown automatically if the
     *      string that you try and parse is not an int value)
     * (1) CalculatorException("Illegal Command")
     *      The input command is neither +, -, or /. You must throw this exception explicitly. The
     *      line will look similar to "throw new CalculatorException(<<message>>);"
     * (2) ArithmeticException
     *      The command is "/" and both numbers are int; the second number is 0. If you attempt to perform
     *      num1 / num2, this exception will automatically be performed. You should not need to explicitly throw
     *      this exception.
     *
     * @param tokens The input string to the program tokenized (split up). Should be a String array of three elements:
     *  [num1, command, num2].
     * @return The result of the calculator operation ("num1 + num2", "num1 - num2", or "num1 / num2")
     * @throws ArithmeticException A division by zero has occured.
     * @throws NumberFormatException Thrown if the first or third token is not convertible from String to int.
     * @throws CalculatorException Thrown if the second token is not a valid command ("+", "-", or "/")
     */
    protected static int calculateThreeTokens(String[] tokens)
            throws ArithmeticException, NumberFormatException, CalculatorException
    {
        // TODO: complete this...
    }

    /**
     * Method to execute the expression encoded in a sequence of tokens. The user input is tokenized in parseAndExecute
     * and the tokens are passed as an array to this method.  For each number of tokens that the program receives, this
     * method will behave in different ways. The methods calculateTwoTokens and calculateThreeTokens will be used as
     * helper methods. They handle the cases where the number of tokens = 2 and = 3.
     *
     * That is, for each number of tokens, the program expects a certain format of input. When
     * the input does not match its expectations, the program should throw an exception. Follow
     * the below cases to determine when you should throw an exception. The cases outline all
     * possibilities for inputs - all the ways an input can be formatted both correctly and
     * incorrectly, and how to choose what to do as a result (operate normally or throw and
     * exception).
     *
     * 0 tokens: throw a CalculatorException(message="Illegal Token Length", type=0)
     * 1 token:
     *      token[0] = "quit": return Integer.MIN_VALUE (i.e. the program should quit)
     *      token[0] = anything else: throw a CalculatorException(message="Illegal Command", type=1)
     * 2 tokens: return the result of calculateTwoTokens(tokens)
     * 3 tokens: return the result of calculateThreeTokens(tokens)
     * 4+ tokens: throw a CalculatorException(message="Illegal Token Length", type=0)
     *
     * @param tokens The input string to the calculator split into tokens and passed as a String array.
     * @throws ArithmeticException A division by zero has occurred.
     * @throws NumberFormatException Thrown if a numeric token is not convertible from String to int.
     * @throws CalculatorException Thrown if the command token is not a valid command ("quit", "negate", "halve"
     * "+", "-", "/"). For the 3 tokens case, the command token is the second token (e.g. "1 + 3", + is the command).
     * For the 2 tokens case, the command token is the first token (e.g. "halve 2", halve is the command.
     */
    protected static int execute(String[] tokens) throws NumberFormatException, CalculatorException
    {
        // Condition on the number of tokens (number of strings in user input separated by spaces)
        switch(tokens.length)
        {
            // TODO: complete this...
        }

    }

    /**
     * Method to split up the user input. "Tokenizes" (converts a large string into string chunks) by splitting the
     * input string on spaces. The tokenized input is passed to execute to be processed. If the input is bad, execute
     * will throw an exception. If the input is valid, an int value will be returned. An int value of Integer.MIN_VALUE
     * is returned by execute if the program should quit.
     *
     * This method handles the exceptions thrown by execute. The string returned by this method is the final result
     * of processing a user input, whether it be a valid or invalid command.
     *
     * Valid commands are:
     * "quit" - the program should quit
     * "increment" - an int should be incremented by 1
     * "decrement" - an int should be decremented by 1
     * "+" - two numbers should be added
     * "-" - a number should be subtracted from another
     * "/" - a number should be divided by another
     *
     * @param input A String possibly containing a calculator command. Tokens of the command are separated by space.
     * e.g. A valid command would be "50 + 20". This will be split up (Tokenized) as an array of three Strings:
     * ["50", "+", "20"].
     * @return The following values are returned under the given conditions:
     * (1) "quit" - if the program should end
     * (2) "The result is: %d", where %d is replaced with the returned value of execute(tokens) - the command is
     * executed correctly and is not "quit".
     * (3) "Attempted to divide by 0. Please try again." - an ArithmeticException has been caught.
     * (4) "Input number cannot be parsed to an int. Please try again." - a NumberFormat has been caught.
     * (5) "Calculator Exception, message is: %s", where %s is the message of a
     * CalculatorException - a CalculatorException has been caught.
     */
    public static String parseAndExecute(String input)
    {
        // TODO: complete this...
        // Hint: you should try and call execute(). If execute encounters an error, it will throw an exception. This
        // method will catch those exceptions and respond accordingly.
    }
}
