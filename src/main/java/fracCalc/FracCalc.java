/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args)
    {
    	
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	String frac = " + ";
    	while(!frac.equals("quit"))
		{
			
			System.out.println(produceAnswer(frac));
	    	System.out.println("Enter the equation (to stop type 'quit'): ");
	    	frac = userInput.nextLine();
		}
    	
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
    	int spaceIndex1 = input.indexOf(" ");
    	String firstValue = input.substring(0, spaceIndex1);
    	String operand = input.substring(spaceIndex1 + 1, spaceIndex1 + 2);
    	String secondValue = input.substring(spaceIndex1 + 3);
    	int wholeIdx = 0;
    	String whole = "0";
    	String numerator = "0";
    	String denominator = "1";
    	
    	int i = 0;
    	int slashIdx = 0;
    	while(i < secondValue.length())
    	{
    		if(secondValue.substring(i, i+1).equals("/"))
    		{
    			slashIdx = i;
    		}
    		if(secondValue.substring(i, i+1).equals("_"))
    		{
    	    	wholeIdx = i;
    		}
    		i++;
    	}
    	
    	if(wholeIdx !=0)
    	{
    		whole = secondValue.substring(0, wholeIdx);
    		wholeIdx++;
    	}
    	if(slashIdx !=0)
    	{
    		
    		numerator = secondValue.substring(wholeIdx, slashIdx);
    		denominator = secondValue.substring(slashIdx+ 1);
    	} else {
    		numerator = secondValue;
    	}
    	String retVal = "whole:"+ whole + " numerator:" + numerator + " denominator:" + denominator;
    	retVal = secondValue;
        return retVal;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
