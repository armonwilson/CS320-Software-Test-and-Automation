/*
 * Armon Wilson
 * SNHU
 * CS-320 Software Test & Automation
 * Project 1
 */

package contactService;

public class Contact {
	private final String uniqueID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	// Constructor
    public Contact(String uniqueID, String firstName, String lastName, String number, String address) throws Exception {
        // Validate uniqueID
        if (uniqueID == null || uniqueID.length() > 10) {
            throw new IllegalArgumentException("Invalid uniqueID. It cannot be empty, or exceed 10 characters.");
        }
        this.uniqueID = uniqueID;

        // Set other fields using their respective setters
        setFirstName(firstName);
        setLastName(lastName);
        setNumber(number);
        setAddress(address);
    }
	
	// Get uniqueID
	public String getUniqueID() {return uniqueID;}
	
	// Get firstName
	public String getFirstName() {return firstName;}
		
	// Set firstName
	public void setFirstName(String userFirstName) throws Exception {
		// Null Exception
		if (userFirstName == null) {
			throw new IllegalArgumentException("First Name cannot be empty.");
		}
		// Character limit exception
		if (userFirstName.length() > 10) {
			throw new IllegalArgumentException("Character limit exceeded. 10 charactors max allowed.");
		} 
		else {
			firstName = userFirstName;
		}
	}
		
	// Get lastName
	public String getLastName() {return lastName;}
	
	//Set lastName
	public void setLastName(String userLastName) throws Exception {
		// Null Exception
		if (userLastName == null) {
			throw new IllegalArgumentException("Last Name cannot be empty.");
		}
		// Character limit exception
		if (userLastName.length() > 10) {
			throw new IllegalArgumentException("Character limit exceeded. 10 charactors max allowed.");
		} 
		else {
			lastName = userLastName;
		}
	}
	
	// Get Number
	public String getNumber() {return number;}
	
	// Set Number
	public void setNumber(String userNumber) throws Exception {
		// Null Exception
		if (userNumber == null) {
			throw new IllegalArgumentException("Number cannot be empty.");
		}
		// Character limit exception
		if (!(userNumber.length() == 10)) {
			throw new IllegalArgumentException("Character limit exceeded. Number must be 10 digits.");
		} 
		else {
			number = userNumber;
		}
	}
	
	//Get Address
	public String getAddress() {return address;}
	
	//Set Address
	public void setAddress(String userAddress) throws Exception {
		//Null Exception
		if (userAddress == null) {
			throw new IllegalArgumentException("Address cannot be empty.");
		}
		// Character limit exception
		if (userAddress.length() > 30) {
			throw new IllegalArgumentException("Required 30 characters not reached.");
		} 
		else {
			address = userAddress;
		}
	}	
	
};