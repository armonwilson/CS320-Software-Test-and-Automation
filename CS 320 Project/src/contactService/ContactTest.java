/*
 * Armon Wilson
 * SNHU
 * CS-320 Software Test & Automation
 * Project 1
 */

package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	// Create Contact
	@Test
	void CreateContact() throws Exception {
		Contact contactTest = new Contact("testID", "firstName", "lastName", "1234567890", "this is the test address");
		assertTrue(contactTest.getUniqueID().equals("testID"));
		assertTrue(contactTest.getFirstName().equals("firstName"));
		assertTrue(contactTest.getLastName().equals("lastName"));
		assertTrue(contactTest.getNumber().equals("1234567890"));
		assertTrue(contactTest.getAddress().equals("this is the test address"));
	}
	
	// Unique ID exception Tests 
	@Test
	void tooManyCharactorsInID(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testIdTooLong", "firstName", "lastName", "1234567890", "this is the test address");
		});
	}
	@Test
	void contactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(null, "firstName", "lastName", "1234567890", "this is the test address");
		});
	}
	
	// First Name exception Tests
	@Test
	void tooManyCharactorsFirstName(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testId", "firstNameIsTooLong", "lastName", "1234567890", "this is the test address");
		});
	}
	@Test
	void contactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("testId", null, "lastName", "1234567890", "this is the test address");
		});
	}
	
	// Last Name Exception Tests
	@Test
	void tooManyCharactorsLastName(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testId", "firstName", "lastNameIsTooLong", "1234567890", "this is the test address");
		});
	}
	@Test
	void contactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("testId", "firstName", null, "1234567890", "this is the test address");
		});
	}
	
	// Number Exception Tests
	@Test
	void tooManyCharactorsNumber(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testId", "firstName", "lastName", "12345678910", "this is the test address");
		});
	}
	@Test
	void notEnoughCharactorsNumber(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testId", "firstName", "lastName", "12345678", "this is the test address");
		});
	}
	@Test
	void contactNumberIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("testId", "firstName", "lastName", null, "this is the test address");
		});
	}
	
	// Address Exception Tests
	@Test
	void tooManyCharactorsAddress(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("testId", "firstName", "lastName", "1234567890", "this is the test address which may or may not be too long");
		});
	}
	@Test
	void contactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("testId", "firstName", "lastName", "1234567890", null);
		});
	}
	
}


