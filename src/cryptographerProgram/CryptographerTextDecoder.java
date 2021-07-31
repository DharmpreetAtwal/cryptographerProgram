package cryptographerProgram;

import java.util.Scanner;
/**
 * <h1> CryptographerTextDecoder Class Description: </h1>
 * <p> Gather's decryption info from the user and decrypt's the message inputted by the user</p>
 * @author Dharmpreet Atwal
 **/
public class CryptographerTextDecoder {
	static StringBuffer encryptedText;
	static int encryptionKey;
	static StringBuffer unGroupedText;
	static StringBuffer decryptedText;
	static Scanner input = new Scanner(System.in);
	
	/**
	 * <h1> main Method Description: </h1>
	 * <p> Calls all the required methods needed to decrypt the text. </p>
	 * @param args 
	 * <br> </br>
	 * @author Dharmpreet Atwal
	 **/
	public static void main(String[]args) {
		
		// Calling the Methods and Outputing their results
		getDecryptionInfo();
		
		unGroupedText = unGroup(encryptedText);
		System.out.println("The unGroupedText is:");
		System.out.println(unGroupedText);
		TestProgram.testUnGroupText();
		System.out.println("---------------------");

		decryptedText = simpleDecrypt(encryptionKey, unGroupedText);
		System.out.println("The decryptedText is:");
		System.out.println(decryptedText);
		System.out.println("---------------------");

	}
	/**
	 * <h1> getDecryptionInfo Method Description: </h1>
	 * <p> Gathers the information needed to decrypt the text. </p>
	 * @author Dharmpreet Atwal
	 **/
	public static void getDecryptionInfo() {
		
		// Prompting the user for input and assigning it to a variable 
		System.out.println("Please enter the message you will like to decrypt.");
		encryptedText = new StringBuffer(input.nextLine());
		
		System.out.println("Please enter the encryption Key.");
		encryptionKey = input.nextInt();
		
	}
	/**
	 * <h1> unGroup Method Description: </h1>
	 * <p> Remove's any blank spaces or asterixes in the encryptedText </p>
	 * @author Dharmpreet Atwal
	 **/
	public static StringBuffer unGroup(StringBuffer encryptedText) {
		
		// Looping through the groupedText and deleting any spaces or asterixes 
		for (int index=0; index<encryptedText.length(); index++) {
			if (Character.isWhitespace(encryptedText.charAt(index)) || encryptedText.charAt(index)== '*') {
				encryptedText.deleteCharAt(index);
			}
		}
		
		return encryptedText;
		
	}
	/**
	 * <h1> simpleDecrypt Method Description: </h1>
	 * <p> Takes the unGrouped encrypted Text and decrypts it by shifting by the <br> negative value of the encryption Key</p>
	 * @author Dharmpreet Atwal
	 **/
	public static StringBuffer simpleDecrypt(int encryptionKey, StringBuffer unGroupedText) {
		int asciiValue;
		int wrapAround;
		
		encryptionKey *= -1;
		encryptionKey = encryptionKey % 26;
		
		// Looping through the unGrouped text string and shifting each character
		for (int index=0; index<unGroupedText.length();index++) {
					
		// Finding the ASCII value of the character being shifted 
		asciiValue = unGroupedText.charAt(index);
					
		// Determining if shifting the ASCII value will go out of the 65-90 range (A-Z)
			if ((asciiValue+encryptionKey) > 90) {
			
				// Determining the difference from the letter being encrypted and Z
				wrapAround = 90 - unGroupedText.charAt(index);
				// Staring the shift over at the character before A
				asciiValue = 64;
				// Assigning the shifted character based on the ASCII value of the original, the encryption key, and the wrap around
				unGroupedText.setCharAt(index, (char)(asciiValue+(encryptionKey - wrapAround)));
			
			} else if ((asciiValue+encryptionKey)<65) {
		
				// Determining the difference from the letter being encrypted and A
				wrapAround = unGroupedText.charAt(index) - 65;
				// Staring the shift over at the character before Z
				asciiValue = 91;
				unGroupedText.setCharAt(index, (char)(asciiValue+(encryptionKey + wrapAround)));
	
			} else {
				// Assigning the shifted character based on the added value between the orginal ASCII value and the encryption key
				unGroupedText.setCharAt(index, (char)(asciiValue+(encryptionKey)));
			}	
					
		}
		
		return unGroupedText;
		
	}
	
}
