package cen4802;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for CEN 4802C-15913, Software Integration, Configuration, and Testing, Assignment 2.
 * 
 * @author  Stephen Sturges Jr
 * @version 09/25/2022
 */
public class Assignment5 {

    /**
     * Calls the recursiveFibSeq method and outputs to the console a String with the nth term and value of the Fibonacci sequence. Output string changes ordinal indicator depending on the n value used.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Get user input.
    	int n = userInputInt("Please enter a value between 0 and 50 (limited for computing time) for n: ", 0, 50);
        // Calculate Fibonacci value.
        long result = recursiveFibSeq(n);
        // Display result in the console.
        System.out.println(displayResult(n, result));
    }

    /**
     * Returns the nth term of the Fibonacci sequence, calculated recursively.
     * 
     * @author  Stephen Sturges Jr
     * @param n The nth term of the Fibonacci sequence.
     * @return  long value of the nth term of the Fibonacci sequence.
     */
    public static long recursiveFibSeq(long n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        return recursiveFibSeq(n - 1) + recursiveFibSeq(n - 2); // F(n) = F(n-1) + F(n-2)
    }
    
	/**
	 * Used to get an integer value from the user and validate it is within bounds. Handles incorrect inputs such as strings, doubles, etc.
	 * 
	 * @param inputPrompt	A string prompting the user for input.
	 * @param lowerBound	An integer representing the lowest acceptable value the user can input.
	 * @param upperBound	An integer representing the highest acceptable value the user can input.
	 * @return				Validated integer input from the user.
	 */
	public static int userInputInt(String inputPrompt, int lowerBound, int upperBound) {
		Scanner input = new Scanner(System.in);
		int userInput = 0;	// Return variable.
		boolean goodInput = false;	// Loop control variable.
		// User input validation loop.
		while (!goodInput) {
			try {
				System.out.print(inputPrompt);
				userInput = input.nextInt();
				if (userInput >= lowerBound && userInput <= upperBound) {
					goodInput = true;
				} else {
					System.out.println("\nINVALID ENTRY: Please enter a value between " + lowerBound + " and " + upperBound + ".");
					goodInput = false;
				} // End of if-else statement.
			} catch (InputMismatchException ime) {
				System.out.println("\nINVALID ENTRY: Please enter a whole number only.");
				goodInput = false;
			} // End of try-catch statement.
		} // End of while loop.
		input.close();
		return userInput;
	} // End of userInputInt method.
    
    /**
     * Displays the result of the Fibonacci calculation associated with the requested nth term.
     * 
     * @param n			The nth term requested by the user.
     * @param result	The value associated with the nth term of the fibonacci sequence.
     */
    public static String displayResult(int n, long result) {
    	// Convert requested value to a char array.
    	char[] inputValue = Integer.toString(n).toCharArray();
    	StringBuilder sb = new StringBuilder();
    	sb.append("The ");
    	sb.append(n);
    	// If the number in the ones place of the converted value is 1, 2, or 3, the output string is changed to represent, for example, 21st, 22nd, or 23rd.
        if (n >= 10 && inputValue[inputValue.length - 2] == '1') {
        	sb.append("th ");
        } else {
            switch (inputValue[inputValue.length - 1]) {
                case '1':
                	sb.append("st ");
                    break;
                case '2':
                	sb.append("nd ");
                    break;
                case '3':
                	sb.append("rd ");
                    break;
                default:
                	sb.append("th ");
                    break;
            }
        }
        sb.append("term of the Fibonacci sequence is " + result + ".");
        return sb.toString();
    }
    
}