package cryptographerProgram;

import java.util.Scanner;

/**
 * <h1> encryptDecryptSelect Class Description:</h1>
 * <p1> Allows the user to decide at the start and end of the program whether <br>
 * they would like to encrypt or decrypt </p1> 
 * @author Dharmpreet Atwal
 */
public class encryptDecryptSelect {
	
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		String strSelector;
			
		System.out.println("Would you like to (E) ncrypt or (D) ecrypt a message?");
		strSelector = input.next();
		
		do {
			
			if (strSelector.equalsIgnoreCase("E")) {
				cryptographerProgram.CryptographerTextEncoder.main(args);
			} else if (strSelector.equalsIgnoreCase("D")) {
				cryptographerProgram.CryptographerTextDecoder.main(args);
			} else {
				System.out.println("Please Enter either E or D");
				System.out.println("---------------------");
				main(args);
			}
		
			System.out.println("Would you like to (E) ncrypt or (D) ecrypt another message?");
			strSelector = input.next();
		
		} while (strSelector.equalsIgnoreCase("E") || strSelector.equalsIgnoreCase("D"));
		
		cryptographerProgram.TestProgram.main(args);
	}
	
}
