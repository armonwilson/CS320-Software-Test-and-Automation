package appointmentService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class AppointmentTest {

	@Test
	// Test for Constructor
	void createAppointmentTest() throws Exception {
		
		// Date Pass variable
		String passDate = "2025-10-05 08:00:00";
		SimpleDateFormat trueDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date expectedDatePass = trueDate.parse(passDate);
		
		// Initialize constructor for passing tests
		Appointment testAppointment = new Appointment("0123456789", passDate, "Appointment Description");
		Assertions.assertTrue(testAppointment.getAppointmentID().equals("0123456789"));
		Assertions.assertTrue(testAppointment.getDate().equals(expectedDatePass));
		Assertions.assertTrue(testAppointment.getDescription().equals("Appointment Description"));
		
		// Null ID Test
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			Appointment nullAppointment = new Appointment(null, passDate, "Appointment Description");
		});
		
		// ID too long Test
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			Appointment invalidIdAppointment = new Appointment("12345678910", passDate, "Appointment Description");
		});
	}
	
	@Test
	//Test for setDate() method
	void setDateTest() throws Exception, ParseException, NullPointerException {
		// Date Pass variable
		String passDate = "2025-10-05 08:00:00";
		SimpleDateFormat trueDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date expectedDatePass = trueDate.parse(passDate);
		
		// Date Fail variables
		String failDate = "2023-10-05 08:00:00";
		
		// Date Null variable
		String dateIsNull = null;
		
		// Appointment object initialization
		Appointment testAppointment = new Appointment("0123456789", passDate, "Appointment Description");
		
		// Positive test case
		Assertions.assertTrue(testAppointment.getDate().equals(expectedDatePass));
		
		// Fail test case
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			testAppointment.setDate(failDate);
		});
		
		// Null test case
		Assertions.assertThrows(NullPointerException.class,()-> {
			testAppointment.setDate(dateIsNull);	
		});	
	}
	
	@Test
	// Test for setDescription() method
	void setDescriptionTest() throws Exception {
		// Passing variable
		String descriptionPass = "Passing Description";
		
		// Failing variable for too many characters
		String descriptionFail = "This will be the failing variable. It will fail because it is needlessly long and I have no idea how many characters this actually is but this should be enough.";
		
		// Failing Null description variable
		String descriptionNull = null;
		
		// initialize appointment object
		Appointment testAppointment = new Appointment("0123456789", "2025-10-05 08:00:00", "Appointment Description");
		
		// Passing test case
		testAppointment.setDescription(descriptionPass);
		Assertions.assertTrue(testAppointment.getDescription().equals(descriptionPass));
		
		// Failing test case. 
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			testAppointment.setDescription(descriptionFail);
		});
		
		// Null test case
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			testAppointment.setDescription(descriptionNull);
		});
	}
	
}
 