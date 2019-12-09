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
    	String frac = "";
    	while(!frac.equals("quit"))
		{
 //Loops until the user types "quit"
			if(!frac.equals("")) {
				System.out.println(produceAnswer(frac));
			}
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
    public static String add(int num1, int den1, int num2, int den2) 
    {
  //method to add 2 fractions
    	if(den1 != den2)
    	{
    		int val = den1;
    		den1 *= den2;
    		num1 *= den2;
    		
    		den2 *= val;
    		num2 *= val;
    	}
    	
    	
    	return reduceFrac((num1+num2),(den1));
    }
    public static String multiply(int num1, int den1, int num2, int den2) 
    {
    //method to multiply 2 fractions
    	return reduceFrac((num1 * num2), (den1 * den2));
    }
    public static String divide(int num1, int den1, int num2, int den2) 
    {
    //method to divide 2 fractions
    	int val = num2;
    	num2 = den2;
    	den2 = val;
    	
    	
    	return reduceFrac((num1 * num2),(den1 * den2));
    }
    public static String subtract(int num1, int den1, int num2, int den2) 
    {
    	//method to subtract 2 fractions
    	if(den1 != den2)
    	{
    		int val = den1;
    		den1 *= den2;
    		num1 *= den2;
    		den2 *= val;
    		num2 *= val;
    	}
    	
    	
    	return reduceFrac((num1-num2),(den1));
    }
    
    public static String reduceFrac(int num, int den)
    {
    	//method to reduce two fractions
    	int GCF = 1;
    	int whole = 0;
    	for(int i=1; i<=Math.abs(num); i++)
    	{
    		//loops to find greatest common factor
    		if(((num % i) == 0) && ((den % i)== 0))
    		{
    			GCF = i;
    		}
    	}
    	num /= GCF;
    	den /= GCF;
    	String retval = "";
    	//checks to see if the solution is zero
    	if(num == 0)
    	{
    		retval = "0";
    	}
    	else if( Math.abs(den) == 1)
    	{
    		retval = num / den + "";
    	}
    	else if(num/den !=0)
    	{
    		
    		whole = num/den;
			num = Math.abs(num);
			den = Math.abs(den);
    		num = Math.abs(num % den);
    		retval = whole + "_" + num + "/" + den;
    	}
    	else
    	{
    		//checks to see if the result will be negative
    		if((double)num/den < 0)
    		{
    			num *= den/Math.abs(den);
    			den = Math.abs(den);
    		}
    		retval = num + "/" + den;
    	}
    	return retval;
    }
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
    	int spaceIndex1 = input.indexOf(" ");
    	//finds the first val, second val, and operand
    	String firstValue = input.substring(0, spaceIndex1);
    	String operand = input.substring(spaceIndex1 + 1, spaceIndex1 + 2);
    	String secondValue = input.substring(spaceIndex1 + 3);
    	
    	//sets the default values of each variable
    	int wholeIdx1 = 0;
    	String whole1 = "0";
    	String numerator1 = "0";
    	String denominator1 = "1";
    	
    	int slashIdx1 = 0;
    	
    	
    	int i = 0;
    	while(i < firstValue.length())
    	{
    		//loops to find the indexes of slash and underscore
    		if(firstValue.substring(i, i+1).equals("/"))
    		{
    			slashIdx1 = i;
    		}
    		if(firstValue.substring(i, i+1).equals("_"))
    		{
    	    	wholeIdx1 = i;
    		}
    		i++;
    	}
    	
    	if(wholeIdx1 !=0)
    	{
    		//finds the whole number
    		whole1 = firstValue.substring(0, wholeIdx1);
    		wholeIdx1++;
    	}
    	if(slashIdx1 !=0)
    	{
    		numerator1 = firstValue.substring(wholeIdx1, slashIdx1);
    		denominator1 = firstValue.substring(slashIdx1 + 1);
    	} 
    	else if (!firstValue.equals(""))
    	{
    		numerator1 = firstValue;
    	}
    	else
    	{
    		numerator1 = "0";
    	}
    	
    	int wholeIdx2 = 0;
    	String whole2 = "0";
    	String numerator2 = "0";
    	String denominator2 = "1";
    	int slashIdx2 = 0;
    	
    	
    	//finds info for second value
    	 i = 0;
    	while(i < secondValue.length())
    	{
    		if(secondValue.substring(i, i+1).equals("/"))
    		{
    			slashIdx2 = i;
    		}
    		if(secondValue.substring(i, i+1).equals("_"))
    		{
    	    	wholeIdx2 = i;
    		}
    		i++;
    	}
    	
    	if(wholeIdx2 !=0)
    	{
    		whole2 = secondValue.substring(0, wholeIdx2);
    		wholeIdx2++;
    	}
    	if(slashIdx2 !=0)
    	{
    		numerator2 = secondValue.substring(wholeIdx2, slashIdx2);
    		denominator2 = secondValue.substring(slashIdx2 + 1);
    	} 
    	else if (!secondValue.equals(""))
    	{
    		numerator2 = secondValue;
    	}
    	else
    	{
    		numerator2 = "0";
    	}

    	//finds the improper fraction of the first value
    	int intNumerator1 = Math.abs(Integer.parseInt(whole1)) * Integer.parseInt(denominator1) + Integer.parseInt(numerator1) ;
    	if(Integer.parseInt(whole1)<0)
    	{
    		intNumerator1 *= -1;
    	}
    	int intDenominator1 = Integer.parseInt(denominator1);
    	
    	//finds the improper fraction of the second value
    	int intNumerator2 = Math.abs(Integer.parseInt(whole2)) * Integer.parseInt(denominator2) + Integer.parseInt(numerator2) ;
    	if(Integer.parseInt(whole2)<0)
    	{
    		intNumerator2 *= -1;
    	}
    	int intDenominator2 = Integer.parseInt(denominator2);

    	//checks to see which operand should be used
    	String retVal = "";
    	if(operand.equals("+"))
    	{
    		retVal = add(intNumerator1, intDenominator1,intNumerator2, intDenominator2);
    	}
    	if(operand.equals("-"))
    	{
    		retVal = subtract(intNumerator1, intDenominator1,intNumerator2, intDenominator2);	
    	}
    	if(operand.equals("*"))
    	{
    		retVal = multiply(intNumerator1, intDenominator1,intNumerator2, intDenominator2);
    	}
    	if(operand.equals("/"))
    	{
    		retVal = divide(intNumerator1, intDenominator1,intNumerator2, intDenominator2);
    	}
    	
 //   	retVal = "whole:"+ whole2 + " numerator:" + numerator2 + " denominator:" + denominator2;
    	
    	
        return retVal;
    }
    

    // TODO: Fill in the space below with any helper methods that you think you will need

}
