package appointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	@Test
	// Test for adding an appointment object to a HashMap
	public void addAppointmentTest() throws Exception{
		
		// initialize service
		AppointmentService appointmentService = new AppointmentService();
		
		// Create Date variables for test
		String passDate = "2025-10-05 08:00:00";
		SimpleDateFormat trueDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date expectedDatePass = trueDate.parse(passDate);
		
		// initialize appointment object
		appointmentService.addAppointment("0123456789", passDate, "Appointment Description");
		
		// verify addition to data structure
		Appointment testAppointment = appointmentService.getAppointment("0123456789");
		Assertions.assertTrue(testAppointment.getAppointmentID().equals("0123456789"));
		Assertions.assertTrue(testAppointment.getDate().equals(expectedDatePass));
		Assertions.assertTrue(testAppointment.getDescription().equals("Appointment Description"));
	}
	
	@Test
	// Test getAppointment() Method
	public void getAppointmentTest() throws Exception {
		// initialize service
		AppointmentService appointmentService = new AppointmentService();
				
		// Create Date variables for test
		String passDate = "2025-10-05 08:00:00";
		SimpleDateFormat trueDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date expectedDatePass = trueDate.parse(passDate);
				
		// initialize appointment object
		appointmentService.addAppointment("0123456789", passDate, "Appointment Description");
		
		// Test case for no key found
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			appointmentService.getAppointment("050505");
		});
	}
	
	@Test
	// test removeAppointment() method
	public void removeAppointmentTest() throws Exception {
			
		//initialize service
		AppointmentService appointmentService = new AppointmentService();
		
		// Create Date variables for test
		String passDate = "2025-10-05 08:00:00";
		SimpleDateFormat trueDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date expectedDatePass = trueDate.parse(passDate);
				
		// initialize appointment object
		appointmentService.addAppointment("0123456789", passDate, "Appointment Description");
		
		// failing test case
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			appointmentService.removeAppointment("123456789");
		});
		
		// Verifying removal of object with key
		appointmentService.removeAppointment("0123456789");
		Assertions.assertFalse(appointmentService.appointments.containsKey("0123456789"));
		
		
	}
}
