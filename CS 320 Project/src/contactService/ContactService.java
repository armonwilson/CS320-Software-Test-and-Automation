/*
 * Armon Wilson
 * SNHU
 * CS-320 Software Test & Automation
 * Project 1
 */

package contactService;

import java.util.HashMap;

public class ContactService {
	
	// Create HashMap for storage of contacts
	public HashMap<String, Contact> ContactMap = new HashMap<>();
	
	// Create new Contact
	public void addContact(String userUniqueID, String  userFirstName, String userLastName, String userNumber, String userAddress) throws Exception {
		Contact contact = new Contact(userUniqueID, userFirstName, userLastName, userNumber, userAddress);
		
		// Add contact to HashMap
		ContactMap.put(contact.getUniqueID(), contact);
	}
		
	// Retrieve Contact
	public Contact getContact(String contactID) throws Exception {
		Contact contact = ContactMap.get(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Contact with ID " + contactID + " not found.");
		}
		return contact; 
	}
	
	// Delete Contact via uniqueID
	public void deleteContact(String contactID) throws Exception {
	    if (ContactMap.containsKey(contactID)) {
	        ContactMap.remove(contactID);
	    }
	    else {
	    	throw new IllegalArgumentException("Contact to delete does not exist.");
	    }
	}
	
	// Update Contact First Name	
	public void updateFirstName(String contactID, String firstName) throws Exception {
		ContactMap.get(contactID).setFirstName(firstName);
	}
	
	// Update Contact Last Name
	public void updateLastName(String contactID, String lastName) throws Exception {
		ContactMap.get(contactID).setLastName(lastName);
	}
	
	// Update Contact Number
	public void updateNumber(String contactID, String number) throws Exception {
		ContactMap.get(contactID).setNumber(number);
	}
		
	// Update Contact Address
	public void updateAddress(String contactID, String address) throws Exception {
		ContactMap.get(contactID).setAddress(address);
	} 
}

