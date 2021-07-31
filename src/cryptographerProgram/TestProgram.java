package cryptographerProgram;

public class TestProgram {

	public static void main(String[] args) {
				
		testNormalizeText();
		testSimpleEncrypt();
		testGroupText();
		
		testUnGroupText();
		testSimpleDecrypt();
	}	
	
	
	/*
	// TEST DONE WITH "AB" AS INPUT
	*/
	
	
	public static void testNormalizeText() {
		StringBuffer input = cryptographerProgram.CryptographerTextEncoder.cleanText;
		StringBuffer expected = new StringBuffer("AB");
		
		if (input == expected) {
			System.out.println("Test normalizeText = true");
		} else {
			System.out.println("Test normalizeText = false");
		}
		
	}
	
	/*
	// TEST DONE WITH "1" AS ENCRYPTION KEY
	*/
	
	public static void testSimpleEncrypt() {
		StringBuffer input = cryptographerProgram.CryptographerTextEncoder.encryptedText;
		StringBuffer expected = new StringBuffer("BC");
		
		if (input == expected) {
			System.out.println("Test simpleDecrypt = true");
		} else {
			System.out.println("Test simpleDecrypt = false");
		}
		
	}
	
	/*
	 * TEST DONE WITH "1" AS LETTER PER GROUP
	 */
	
	public static void testGroupText() {
		StringBuffer input = cryptographerProgram.CryptographerTextEncoder.groupedText;
		StringBuffer expected = new StringBuffer("B C");
		
		if (input == expected) {
			System.out.println("Test groupIt = true");
		} else {
			System.out.println("Test groupIt = false");
		}
		
	}
	
	
	/*
	 * TEST DONE WITH BC AS INPUT
	 */
	
	public static void testUnGroupText() {
		StringBuffer input = cryptographerProgram.CryptographerTextDecoder.unGroupedText;
		StringBuffer expected = new StringBuffer("BC");
		
		if (input == expected) {
			System.out.println("Test groupIt = true");
		} else {
			System.out.println("Test groupIt = false");
		}
		
	}
	
	/*
	 * TEST DONE WITH AB AS INPUT
	 */
	public static void testSimpleDecrypt() {
		StringBuffer input = cryptographerProgram.CryptographerTextDecoder.decryptedText;
		StringBuffer expected = new StringBuffer("AB");
		
		if (input == expected) {
			System.out.println("Test groupIt = true");
		} else {
			System.out.println("Test groupIt = false");
		}
		
	}
	
}		
