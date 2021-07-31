package cryptographerProgram;


import java.util.Scanner;

/**
 * <h1>  Class Description: </h1>
 * <p> Gathers plain text from user and encrypts the message <br> using the encryption information given </p>
 * @author Dharmpreet Atwal
 */

public class CryptographerTextEncoder {
	static String plainText; 
	static StringBuffer cleanText;
	static int encryptionKey;
	static StringBuffer encryptedText;
	static StringBuffer groupedText;
	static int lettersPerGroup;
	static Scanner input = new Scanner(System.in);
	
	/**
	 * <h1>  main Method Description: </h1>
	 * <p> Calls all neccesary methods required to encrypt the text </p>
	 * @author Dharmpreet Atwal
	 */
	public static void main(String[]args) {
		
		// Gathering the information required to encrypt the message through user input
		getEncryptionInfo();
		
		// Turning the value type of normailzeText to StringBuffer and assigning it to cleanText
		StringBuffer cleanText = new StringBuffer(normalizeText(plainText));
		System.out.println("The Clean Text is:");
		System.out.println(cleanText);
		cryptographerProgram.TestProgram.testNormalizeText();
		System.out.println("---------------------");
		
		// Encrypting the cleaned text and assigning it to the encoded Text 
		encryptedText = simpleEncrypt(encryptionKey, cleanText);
		System.out.println("The encryptedText is:");
		System.out.println(encryptedText);
		cryptographerProgram.TestProgram.testSimpleEncrypt();
		System.out.println("---------------------");

		// Grouping the encrypted text
		groupedText = groupText(lettersPerGroup, encryptedText);
		System.out.println("The grouped Text is:");
		System.out.println(groupedText);
		cryptographerProgram.TestProgram.testGroupText();
		System.out.println("---------------------");
		
	}
	/**
	 * <h1>  getEncryptionInfo Method Description: </h1>
	 * <p> Gathers the required information needed to encrypt the program </p>
	 * @author Dharmpreet Atwal
	 */
	public static void getEncryptionInfo() {
		
		// Prompting the user for input and assigning that input to a variable 
		System.out.println("Please enter the message you will like to encrypt.");
		plainText = input.nextLine();
		System.out.println("Please enter in the encryption key.");
		encryptionKey = input.nextInt();
		System.out.println("Enter in the letters per group");
		lettersPerGroup = (input.nextInt());
		
	}
	/**
	 * <h1>  normalizeText Method Description: </h1>
	 * <p> Removes blank spaces and other unwanted characters <br> from the text and makes all the letters capital</p>
	 * 
	 * @author Dharmpreet Atwal
	 */
	public static String normalizeText(String cleanText) {
		String punctuation = ".,:;!?\\!?()\" ";
		
		// Looping through  the message and replacing any unwanted characters with blank spaces
		for (int index=0; index<punctuation.length(); index++) {
			plainText = plainText.replace(""+punctuation.charAt(index), "");
		}
		
		plainText = plainText.toUpperCase();
		
		return plainText;
	}
	/**
	 * <h1>  simpleEncrypt Method Description: </h1>
	 * <p> Takes the normalized text and encrypts it to shifting each letter by the encryption <br> key</p>
	 * @author Dharmpreet Atwal
	 */
	public static StringBuffer simpleEncrypt(int encryptionKey, StringBuffer cleanText) {
		int asciiValue;
		int wrapAround;
		
		// Finding the remainder of the encryption key to figure out how many shifts are required relative to the number 26
		encryptionKey = encryptionKey % 26;
		
		// Looping through the clean text string and shifting each character
		for (int index=0; index<cleanText.length();index++) {
			
			// Finding the ASCII value of the character being shifted 
			asciiValue = cleanText.charAt(index);
			
			// Determining if shifting the ASCII value will go out of the 65-90 range (A-Z)
			if ((asciiValue+encryptionKey) > 90) {
				
				// Determining the difference from the letter being encrypted and Z
				wrapAround = 90 - cleanText.charAt(index);
				// Staring the shift over at the character before A
				asciiValue = 64;
				// Assigning the shifted character based on the ASCII value of the original, the encryption key, and the wrap around
				cleanText.setCharAt(index, (char)(asciiValue+(encryptionKey - wrapAround)));
			
			} else if ((asciiValue+encryptionKey)<65) {
			
				// Determining the difference from the letter being encrypted and A
				wrapAround = cleanText.charAt(index) - 65;
				// Staring the shift over at the character before Z
				asciiValue = 91;
				cleanText.setCharAt(index, (char)(asciiValue+(encryptionKey + wrapAround)));
			
			} else {
				// Assigning the shifted character based on the added value between the orginal ASCII value and the encryption key
				cleanText.setCharAt(index, (char)(asciiValue+(encryptionKey)));
			}
			
		}
		
		return cleanText;
	}
	/**
	 * <h1>  groupText Method Description: </h1>
	 * <p> Groups the encrypted text into groups of letters, each group only <br> having a specific number of letters  </p>
	 * @author Dharmpreet Atwal
	 */
	public static StringBuffer groupText(int lettersPerGroup, StringBuffer encryptedText) {

		int asterixes=lettersPerGroup-encryptedText.length()%lettersPerGroup;
		
		// Add the asterixes at the end of the String
		for(int index=0; index<asterixes;index++) {
			encryptedText.append('*') ;
		}
		
		// Grouping the letters of the encrypted text by adding a space every lettersPereGroup interval 
		for (int index=lettersPerGroup; index<encryptedText.length(); index+=lettersPerGroup+1) {
			encryptedText.insert((index) , " ");
		}
		
		return encryptedText;	
	}
	
}
