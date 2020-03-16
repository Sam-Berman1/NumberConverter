package numberconverter;

import java.util.InputMismatchException;
import java.util.Scanner;

/** @author Samuel Berman
 *  Java Program to Convert Numbers from Binary, Hex, and Octal */

public class NumberConverter {

	/** Convert from Binary to Decimal 
	 *  @param BinaryNumber a String representing ones and zeros 
	 *  @throws InvalidNumberException Number is not Binary */
	public static int BinaryToDecimal(String BinaryNumber) {
		int result = 0;
		int power = BinaryNumber.length() - 1;
		int index = 0;
		while (index < BinaryNumber.length())
			
		   {
		   if (BinaryNumber.charAt(index)=='1')
		      result = result + 1 * (int) (Math.pow(2, power));
		   index++; // look at the next digit
		   power--; // change the power of 2 to next digit
		   }
		
		return result;
	}
	
	public int stringMethod(int num) {
		
		return num;
	}
	
	public static int OctalToDecimal(String OctalNumber) {
		int result = 0;
		int power = OctalNumber.length() - 1;   // converts octal to decimal.
		int index = 0;
		while (index < OctalNumber.length())          
			
		   {
			switch (OctalNumber.charAt(index))
			   {
			      case '1': result = result + 1 * (int) (Math.pow(8, power)); break;
			      case '2': result = result + 2 * (int) (Math.pow(8, power)); break;
			      case '3': result = result + 3 * (int) (Math.pow(8, power)); break;
			      case '4': result = result + 4 * (int) (Math.pow(8, power)); break;
			      case '5': result = result + 5 * (int) (Math.pow(8, power)); break;
			      case '6': result = result + 6 * (int) (Math.pow(8, power)); break;
			      case '7': result = result + 7 * (int) (Math.pow(8, power)); break;
			   }
			
			
		   index++; // look at the next digit
		   power--; // change the power of 2 to next digit
		   }
		
		return result;
	}
	
	public static int calculatePositionalValue(int num, int power) {
		// Calculate Largest Positional Value
		int position = 10;
		while (num / Math.pow(power, position) < 1) {
			position--;
		}
		return position;
	}
	
	/** Convert from Decimal to Binary 
	 *  @param DecimalNumber an integer we wish to convert 
	 *  @throws InvalidNumberException Number is not an int */
	public static String DecimalToBinary (int DecimalNumber) {
		String result = "";
		
		int position = calculatePositionalValue(DecimalNumber, 2);  //takes a whole number and turns it into binary
		
		while (position>=0)
			{
			if ( DecimalNumber / (int) Math.pow(2, position)==1)
			   result = result + "1";
			else
			   result = result + "0";
			DecimalNumber = DecimalNumber % (int) Math.pow(2, position);
			position--;
			}
		return result;
	}
	
	public static String DecimalToHex (int DecimalNumber) { // takes a whole number & converts it to Hex
		String result = "";
		
		int power = calculatePositionalValue(DecimalNumber,16); 
	
		while (power>=0) {
			switch (DecimalNumber / (int) Math.pow(16, power)) {
				
			case 1: result = result + "1"; break;
			case 2: result = result + "2"; break;
			case 3: result = result + "3"; break;
			case 4: result = result + "4"; break;
			case 5: result = result + "5"; break;
			case 6: result = result + "6"; break;
			case 7: result = result + "7"; break;
			case 8: result = result + "8"; break;
			case 9: result = result + "9"; break;
			case 10: result = result + "A"; break;
			case 11: result = result + "B"; break;
			case 12: result = result + "C"; break;
			case 13: result = result + "D"; break;
			case 14: result = result + "E"; break;
			case 15: result = result + "F"; break;
			}
			   DecimalNumber = DecimalNumber % (int) Math.pow(16, power);
			   power--; // change the power of ? to next digit
		}
		return result;
	}
		
	/** Convert from Decimal to Octal 
	 *  @param DecimalNumber an integer we wish to convert 
	 *  @returns A String representing the equivalent in Octal
	 *  @throws InvalidNumberException Number is not an int */
	public static String DecimalToOctal (int DecimalNumber) {
		String result = "";
		
		int position = calculatePositionalValue(DecimalNumber, 8);
		
		// Calculate Largest Positional Value
		/*int position = 20; // max allowed number of digits
		int index = 0;
		while (DecimalNumber / Math.pow(8, position) < 1) {
			position--;
		}*/
		
		while (position>=0) // do the conversion
			{
			int quotient = DecimalNumber / (int) Math.pow(8, position);	
			// quotient will be between 0 and 7
			switch (quotient)
			{
				case 0:  result = result + "0";
				break;
				case 1:  result = result + "1";
				break;
				case 2:  result = result + "2";
				break;
				case 3:  result = result + "3";
				break;
				case 4:  result = result + "4";
				break;
				case 5:  result = result + "5";
				break;
				case 6:  result = result + "6";
				break;
				case 7:  result = result + "7";
				break;
				
			}
			// Set Decimal Number to the Remainder
			DecimalNumber = DecimalNumber % (int) Math.pow(8, position);
			position--;
			}
		return result;
	}
	
	
	/** Convert from Octal to Decimal 
	 *  @param OctalNumber a String representing a number with digits from 0 to 7 
	 *  @throws InvalidNumberException Number is not Octal */
	public static int DecimalToOctal(String OctalNumber) {
		int result = 0;
		int power = OctalNumber.length() - 1;
		int index = 0;
		while (index < OctalNumber.length())
		   {
		   switch (OctalNumber.charAt(index))
		   {
		      case '1': result = result + 1 * (int) (Math.pow(8, power)); break;
		      case '2': result = result + 2 * (int) (Math.pow(8, power)); break;
		      case '3': result = result + 3 * (int) (Math.pow(8, power)); break;
		      case '4': result = result + 4 * (int) (Math.pow(8, power)); break;
		      case '5': result = result + 5 * (int) (Math.pow(8, power)); break;
		      case '6': result = result + 6 * (int) (Math.pow(8, power)); break;
		      case '7': result = result + 7 * (int) (Math.pow(8, power)); break;
		   }
		   index++; // look at the next digit
		   power--; // change the power of 8 to next digit
		   }
		
		return result;
	}
	
	
	/** Convert from Hex to Decimal 
	 *  @param HexNumber a String representing a number with digits from 0-9 and A-F 
	 *  @throws InvalidNumberException Number is not Hex */
	public static int HexToDecimal(String HexNumber) {
		int result = 0;
		int power = HexNumber.length() - 1;
		int index = 0;
		HexNumber.toUpperCase();
		
		while (index < HexNumber.length())
		   {
		   switch (HexNumber.charAt(index))
		   {
		      case '1': result = result + 1 * (int) (Math.pow(16, power)); break;
		      case '2': result = result + 2 * (int) (Math.pow(16, power)); break;
		      case '3': result = result + 3 * (int) (Math.pow(16, power)); break;
		      case '4': result = result + 4 * (int) (Math.pow(16, power)); break;
		      case '5': result = result + 5 * (int) (Math.pow(16, power)); break;
		      case '6': result = result + 6 * (int) (Math.pow(16, power)); break;
		      case '7': result = result + 7 * (int) (Math.pow(16, power)); break;
		      case '8': result = result + 8 * (int) (Math.pow(16, power)); break;
		      case '9': result = result + 9 * (int) (Math.pow(16, power)); break;
		      
		      case 'A':
		      case 'a': result = result + 10 * (int) (Math.pow(16, power)); break;
		      case 'B':
		      case 'b': result = result + 11 * (int) (Math.pow(16, power)); break;
		      case 'C':
		      case 'c': result = result + 12 * (int) (Math.pow(16, power)); break;
		      case 'D':
		      case 'd': result = result + 13 * (int) (Math.pow(16, power)); break;
		      case 'E':
		      case 'e': result = result + 14 * (int) (Math.pow(16, power)); break;
		      case 'F':
		      case 'f': result = result + 15 * (int) (Math.pow(16, power)); break;
		   }
		   index++; // look at the next digit
		   power--; // change the power of ? to next digit
		   }
		
		return result;
	}
	
	public static void main(String[] args) {
		try {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number type to convert");
		System.out.println("1 Binary");
		System.out.println("2 Octal");
		System.out.println("3 Decimal");
		System.out.println("4 Hex");
		
		int choice = input.nextInt();
		
		switch (choice) {
			case 1: 
				System.out.println("Enter a Binary Number.");
				String binary = input.next();                                   
				if(binary.matches(".*[a-z].*")) {  // throw case Exception for a letter where a number should be
					throw new InputMismatchException("Should not contain letters.");
				}                                                                   
				if(binary.matches(".*[2-9],*")) { // throw case exception for entering any other number than 1 or 0
					throw new InputMismatchException("Should only contain digits 0 or 1.");
				}
				int Decimal = BinaryToDecimal(binary);
				System.out.printf("Converted: Decimal: %d Octal : %s Hex: %s\n",
						Decimal,DecimalToOctal(Decimal),DecimalToHex(Decimal)); 
				break;
			case 2: 
				System.out.println("Please Enter an Octal Number");   
				String Octal = input.next();
				if(Octal.matches(".*[a-z].*")) {
					throw new InputMismatchException("Should not contain letters."); // octal exception for any letters 
				}
				if(Octal.matches(".*[8-9].*")){
					throw new InputMismatchException("Should only contain digits 0-7."); // octal exception for numbers 8-9
				}
				int octDecimal = OctalToDecimal(Octal);
				System.out.printf("Converted to Decimal: %d Binary: %s Hex: %s\n",
						octDecimal,DecimalToBinary(octDecimal),DecimalToHex(octDecimal));
				break;
			case 3:
				System.out.println("Enter a Decimal Number: "); 
				int number = input.nextInt();
				System.out.printf("Converted to Binary: %s%n", DecimalToBinary(number));
				System.out.printf("Converted to Octal: %s%n", DecimalToOctal(number)); //outputs computations
				System.out.printf("Converted to Hex: %s%n", DecimalToHex(number));
				break;
			case 4:
				System.out.println("Enter a Hex number: ");
				String hex = input.next();
				if(hex.toLowerCase().matches(".*[g-z].*")) {                      // enter hex number and exception
					throw new InputMismatchException("Should only contain letters A-F.");
				}
				int decHex = HexToDecimal(hex);
				System.out.printf("Converted to Decimal: %d Binary: %s Octal: %s\n",
						decHex,DecimalToBinary(decHex),DecimalToOctal(decHex));
				break;
			default:
				throw new InputMismatchException("Wrong input type.");   //default exception if anything else throw this.
		}
		}
		catch(InputMismatchException n) {
			if(n.getMessage() == null) {
				System.out.println("Wrong input type.");
			}
			else {
			System.out.println(n.getMessage());
			}
			NumberConverter.main(args);
		}
	}

}