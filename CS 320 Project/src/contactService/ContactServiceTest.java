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

class ContactServiceTest {
	
	// Test adding & retrieving contact from HashMap using uniqueID
	@Test
	void addContactTest() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("testID", "firstName", "lastName", "1234567890", "This is the test address");
		Contact contact = contactService.getContact("testID");
		assertTrue(contact.getUniqueID().equals("testID"));
		assertTrue(contact.getFirstName().equals("firstName"));
		assertTrue(contact.getLastName().equals("lastName"));
		assertTrue(contact.getNumber().equals("1234567890"));
		assertTrue(contact.getAddress().equals("This is the test address"));
	}
	
	// Test the deletion of a contact
	@Test
	void deleteContactTest() throws Exception {
		ContactService contactService = new ContactService();
		// Create contact to delete
		contactService.addContact("testID", "firstName", "lastName", "1234567890", "This is the test address");
		Contact contact = contactService.getContact("testID");
		// Verify record is created
		assertTrue(contact.getUniqueID().equals("testID"));
		assertTrue(contact.getFirstName().equals("firstName"));
		assertTrue(contact.getLastName().equals("lastName"));
		assertTrue(contact.getNumber().equals("1234567890"));
		assertTrue(contact.getAddress().equals("This is the test address"));
		// Delete contact
		contactService.deleteContact(contact.getUniqueID());
		// Verify contact was deleted
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.getContact("testID");
		});
		// Test arg exception when record to delete does not exist
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.deleteContact("faleID");
		});
	}
	
	// Test update contact first name
	@Test
	void updateFirstNameTest() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("testID", "firstName", "lastName", "1234567890", "This is the test address");
		Contact contact = contactService.getContact("testID");
		assertTrue(contact.getFirstName().equals("firstName"));
		contactService.updateFirstName("testID", "testName");
		assertTrue(contact.getFirstName().equals("testName"));
	}
	
	// Test update contact last name
	@Test
	void updateLastNameTest() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("testID", "firstName", "lastName", "1234567890", "This is the test address");
		Contact contact = contactService.getContact("testID");
		assertTrue(contact.getLastName().equals("lastName"));
		contactService.updateLastName("testID", "testName");
		assertTrue(contact.getLastName().equals("testName"));
	}
	
	// Test update contact number
	@Test
	void updateNumberTest() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("testID", "firstName", "lastName", "1234567890", "This is the test address");
		Contact contact = contactService.getContact("testID");
		assertTrue(contact.getNumber().equals("1234567890"));
		contactService.updateNumber("testID", "test123456");
		assertTrue(contact.getNumber().equals("test123456"));
	}
	
	// test update contact address
	@Test
	void updateAddressTest() throws Exception {
		ContactService contactService = new ContactService();
		contactService.addContact("testID", "firstName", "lastName", "1234567890", "This is the test address");
		Contact contact = contactService.getContact("testID");
		assertTrue(contact.getAddress().equals("This is the test address"));
		contactService.updateAddress("testID", "This is the new test Address");
		assertTrue(contact.getAddress().equals("This is the new test Address"));
	}
}
