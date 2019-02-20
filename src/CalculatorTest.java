/**
 * Test class for calculator class
 *
 * @author Stephen Thung
 * @version 2019-02-13
 */
public class CalculatorTest {

    /**
     * Test correct calculation of two valid tokens (negate):
     */
    public void calculateTwoTokensTestValidNegate() throws AssertException
    {
        try
        {
            int result = Calculator.calculateTwoTokens(new String[] {"negate", "5"});
            Assert.assertEquals(-5, result);
        }
        catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * Test correct calculation of two valid tokens (halve):
     * @throws CalculatorException 
     * @throws NumberFormatException 
     */
    public void calculateTwoTokensTestValidHalve() throws AssertException, NumberFormatException, CalculatorException
    {
    	int result = Calculator.calculateTwoTokens(new String[] {"halve", "6"});
    	Assert.assertEquals(3, result);
    }

    /**
     * Test invalid two-token input (number is not an int):
     */
    public void calculateTwoTokensTestInvalidNumber() throws AssertException
    {
        try
        {
            Calculator.calculateTwoTokens(new String[] {"halve", "foo"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test, thus succeeding.
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not NumberFormatException) caught");
        }
    }

    /**
     * Test invalid two-token input (command is not negate/halve):
     * @throws CalculatorException 
     * @throws NumberFormatException 
     */
    public void calculateTwoTokensTestInvalidCommand() throws AssertException, NumberFormatException, CalculatorException
    {
    	
    	Assert.assertEquals("Calculator Exception, message is: Illegal Command", Calculator.parseAndExecute("add 6"));
    }

    /**
     * Test correct calculation of three valid tokens (+):
     */
    public void calculateThreeTokensTestValidAdd() throws AssertException
    {
    	Assert.assertEquals("The result is: 4", Calculator.parseAndExecute("2 + 2"));
    }

    /**
     * Test correct calculation of three valid tokens (-):
     */
    public void calculateThreeTokensTestValidSubtract() throws AssertException
    {
    	Assert.assertEquals("The result is: 0", Calculator.parseAndExecute("2 - 2"));
    }

    /**
     * Test correct calculation of three valid tokens (/):
     */
    public void calculateThreeTokensTestValidDivide() throws AssertException
    {
    	Assert.assertEquals("The result is: 1", Calculator.parseAndExecute("2 / 2"));
    }

    /**
     * Test invalid three-token input (either number is not an int):
     */
    public void calculateThreeTokensTestInvalidNumber() throws AssertException
    {
        // Try for first number:
        try
        {
            Calculator.calculateThreeTokens(new String[] {"foo", "+", "5"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test, thus succeeding.
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not NumberFormatException) caught");
        }

        // Try for second number:
        try
        {
            Calculator.calculateThreeTokens(new String[] {"5", "+", "foo"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test, thus succeeding.
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not NumberFormatException) caught");
        }
    }

    /**
     * Test invalid three-token input (command is not +/-//):
     */
    public void calculateThreeTokensTestInvalidCommand() throws AssertException
    {
    	Assert.assertEquals("Calculator Exception, message is: Illegal Command", Calculator.parseAndExecute("2 * 2"));
    }

    /**
     * Test correct execution of command (one token - only can be "quit"):
     */
    public void executeTestValidQuit() throws AssertException
    {
    	Assert.assertEquals("quit", Calculator.parseAndExecute("quit"));
    }

    /**
     * Test correct execution of command (any valid two-token command):
     */
    public void executeTestValidTwoTokens() throws AssertException
    {
        try
        {
            int result = Calculator.execute(new String[] {"negate", "5"});
            Assert.assertEquals(-5, result);
        }
        catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * Test correct execution of command (any valid three-token command):
     */
    public void executeTestValidThreeTokens() throws AssertException
    {
    	Assert.assertEquals("The result is: 0", Calculator.parseAndExecute("2 - 2"));
    }

    /**
     * Test invalid execute input (single token; not "quit"):
     */
    public void executeTestInvalidCommand() throws AssertException
    {
        try
        {
            Calculator.execute(new String[] {"foo"});
            Assert.fail("Illegal expression did not throw an Exception");
        }
        catch (CalculatorException e)
        {
            // We expect the function to throw a CalculatorException.
            // Check to make sure the CalculatorException has the correct message and type:
            Assert.assertEquals("Illegal Command", e.getMessage());
        }
        catch (Exception e)
        {
            Assert.fail("Unexpected Exception (not CalculatorException) caught");
        }
    }

    /**
     * Test invalid execute input (invalid token lengths):
     */
    public void executeTestInvalidTokenLength() throws AssertException
    {
        // Token length is 0:
    	Assert.assertEquals("Calculator Exception, message is: Illegal Token Length", Calculator.parseAndExecute(""));

        // Token length is > 3:
    	Assert.assertEquals("Calculator Exception, message is: Illegal Token Length", Calculator.parseAndExecute("5 - 3 * 5"));
    }

    /**
     * Test correct parseAndExecution of command (input of "quit"):
     */
    public void parseAndExecuteTestValidQuit() throws AssertException
    {
        String result = Calculator.parseAndExecute("quit");
        Assert.assertEquals("quit", result);
    }

    /**
     * Test correct parseAndExecution of command (any valid 2 or 3 token command):
     */
    public void parseAndExecuteTestValidCommand() throws AssertException
    {
        String result = Calculator.parseAndExecute("5 + 6");
        Assert.assertEquals("The result is: 11", result);
    }

    /**
     * Test incorrect parseAndExecution of command (divide by zero):
     */
    public void parseAndExecuteTestDivideByZero() throws AssertException
    {
    	Assert.assertEquals("Attempted to divide by 0. Please try again.", Calculator.parseAndExecute("3 / 0"));
    }

    /**
     * Test incorrect parseAndExecution of command (2 or 3 token command with invalid number):
     */
    public void parseAndExecuteTestInvalidNumber() throws AssertException
    {
    	Assert.assertEquals("Input number cannot be parsed to an int. Please try again.", Calculator.parseAndExecute("5 / 2.5"));
    }

    /**
     * Test incorrect parseAndExecution of command (invalid command):
     */
    public void parseAndExecuteTestInvalidCommand() throws AssertException
    {
        String result = Calculator.parseAndExecute("foo 6");
        Assert.assertEquals("Calculator Exception, message is: Illegal Command", result);
    }

    /**
     * Test incorrect parseAndExecution of command (invalid token length):
     */
    public void parseAndExecuteTestInvalidTokenLength() throws AssertException
    {
    	 Assert.assertEquals("Calculator Exception, message is: Illegal Token Length", Calculator.parseAndExecute("4 - 5 / 76"));
    }
}
