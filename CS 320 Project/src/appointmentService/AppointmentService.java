package appointmentService;

import java.util.HashMap;

public class AppointmentService {
	// Create HashMap for storing appointments
	public HashMap<String, Appointment> appointments = new HashMap<>(); 
	
	// Add appointments via unique appointment ID
	public void addAppointment(String uniqueId, String date, String description) throws Exception {
		// create new appointment object
		Appointment appointment = new Appointment(uniqueId, date, description);
		
		// Add appointment object to HashMap
		appointments.put(appointment.getAppointmentID(), appointment);
	}
	
	public Appointment getAppointment(String appointmentID) throws Exception {
		if (appointments.containsKey(appointmentID)) {
			return appointments.get(appointmentID);
		} else {
			throw new IllegalArgumentException("Unique ID for Appointment does not exist");
		}
	}
	
	
	// Delete an Appointment object from HashMap
	public void removeAppointment(String appointmentID)throws Exception {
		if (appointments.containsKey(appointmentID)) {
			appointments.remove(appointmentID);
		} else {
			throw new IllegalArgumentException("Appointment ID does not exist.");
		}
	}
}

/* Appointment Service Requirements:
 * The appointment service shall be able to add appointments with a unique appointment ID.
 * The appointment service shall be able to delete appointments per appointment ID.
*/