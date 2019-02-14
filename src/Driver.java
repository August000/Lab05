import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * THIS CLASS IS COMPLETED FOR YOU. DO NOT EDIT IT!
 *
 * Lab 5
 *
 * Read lines from the user's keyboard.  For each line, attempt to interpret
 * it as a Calculator Command and print out the result (or an error message).
 *
 * Lines are read as long as the user has not requested that the program be quit
 *
 * @author Stephen
 * @version 2019-02-13
 */

public class Driver {

    /**
     * @param args Not used
     * @throws IOException If there is an IO error
     */
    public static void main(String[] args) throws IOException {

        // Open standard in for input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Loop until quit
        while(true)
        {
            System.out.println("Enter a command: negate, halve, +, -, /, quit...");
            // Read the next line of input
            String input = br.readLine();

            // Parse, compute and report the result
            String result = Calculator.parseAndExecute(input);
            if(result.equalsIgnoreCase("quit"))
            {
                // Quit has been specified; end the program:
                break;
            }
            System.out.println(result);
        }

        // Close out the buffered reader
        br.close();
    }
}
