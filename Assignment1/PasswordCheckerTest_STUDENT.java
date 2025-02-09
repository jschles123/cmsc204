
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Joshua Schlesinger-Guevara
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;


	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
		String[] pass = {"ValidPas1!","TwoCharss1!","Sht1!","Weak1!","nowupperpass12!","NOLOWERPASS12!","NoNumbers!","NoSpecialChars1"};
		for(String i : pass){
			passwords.add(i);
		}
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(0));
		} catch (Exception e) {
			fail();
		}
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(2));
			fail("Expected LengthException");
		} catch (LengthException e) {
			// Expected exception
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(0));
		} catch (Exception e) {
			fail();
		}
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(4));
			fail("Expected NoUpperAlphaException");
		} catch (NoUpperAlphaException e) {
			// Expected exception
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(0));
		} catch (Exception e) {
			fail();
		}
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(5));
			fail("Expected NoLowerAlphaException");
		} catch (NoLowerAlphaException e) {
			// Expected exception
		} catch (Exception e) {
			fail();
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			PasswordCheckerUtility.isWeakPassword(passwords.get(0));
		} catch (Exception e) {
			fail();
		}
		try {
			PasswordCheckerUtility.isWeakPassword(passwords.get(3));
			fail("Expected WeakPasswordException");
		} catch (WeakPasswordException e) {
			// Expected exception
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(0));
		} catch (Exception e) {
			fail();
		}
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(1));
			fail("Expected InvalidSequenceException");
		} catch (InvalidSequenceException e) {
			// Expected exception
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(0));
		} catch (Exception e) {
			fail();
		}
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(6));
			fail("Expected NoDigitException");
		} catch (NoDigitException e) {
			// Expected exception
		} catch (Exception e) {
			fail();
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(0));
		} catch (Exception e) {
			fail();
		}
		try {
			PasswordCheckerUtility.isValidPassword(passwords.get(6));
			fail("Expected NoDigitException");
		} catch (Exception e) {
			//Expected
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> Actual = PasswordCheckerUtility.getInvalidPasswords(passwords);
		String[] temp = {"TwoCharss1! The password cannot contain more than two of the same character in sequence",
				"Sht1! The password must be at least 6 characters long",
				"nowupperpass12! The password must contain at least one uppercase alphabetic character"
				,"NOLOWERPASS12! The password must contain at least one lowercase alphabetic character",
				"NoNumbers! The password must contain at least one digit"
				,"NoSpecialChars1 The password must contain at least one special character"};
		ArrayList<String> Expected = new ArrayList<>();
		for (String i : temp){
			Expected.add(i);
		}
		assertTrue(Actual.equals(Expected));
	}
	
}
