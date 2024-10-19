package appointmentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
	public String appointmentID;
	public Date date;
	public String description;
	
	// Default Constructor with error handling
	public Appointment(String uniqueID, String apptDate, String apptDescription)throws Exception {
		if (uniqueID == null || uniqueID.length() > 10) {
			throw new IllegalArgumentException("UniqueID must not be null, and must contain fewer than 10 charactors.");
		} else {
			appointmentID = uniqueID;
		}
		// Use setter methods to set Date & Description
		setDate(apptDate);
		setDescription(apptDescription);
	}
	
	// Getter method
	public String getAppointmentID() {
		return appointmentID;
	}
	
	// Setter Method with error handling
	public void setDate(String apptDate) throws IllegalArgumentException, NullPointerException, ParseException {
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date parsedDate;
	    try {
	        parsedDate = df.parse(apptDate);
	    } catch (NullPointerException e) {
	    	throw e;
	    }

	    if (new Date().after(parsedDate)) {
	        throw new IllegalArgumentException("Date must be in the future.");
	    } else {
	        date = parsedDate;
	    }
	}
	
	// Getter Method
	public Date getDate() {
		return date;
	}
	
	// Setter Method with error handling
	public void setDescription(String apptDescription) throws Exception {
		if (apptDescription == null || apptDescription.length() > 50) {
			throw new IllegalArgumentException("Description cannot be null and must be fewer than 50 charactors.");
		} else {
			description = apptDescription;
		}
	}
	
	// getter Method
	public String getDescription() throws Exception {
		return description;
	}
}

/* Appointment Class Requirements:
 * The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
 * The appointment object shall have a required appointment Date field. The appointment Date field cannot be in the past. The appointment Date field shall not be null.
 * Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
 * The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
 */