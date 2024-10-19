package taskService;

public class Task {
	private String taskID;
	private String taskName;
	private String taskDescription;
	
	// constructor
	public Task(String userID, String userTaskName, String userTaskDescription)throws Exception {
		if (userID == null || userID.length() > 10 ) {
			throw new IllegalArgumentException("Invalid task ID.");
		} 
		else {
			taskID = userID;
		}
		setTaskName(userTaskName);
		setTaskDescription(userTaskDescription);
	}
	
	// get unique ID
	public String getTaskID() {
		return taskID;
	}
	
	// set task name
	public void setTaskName(String userTaskName)throws Exception {
		if (userTaskName == null || userTaskName.length() > 20) {
			throw new IllegalArgumentException("Task Name is invalid.");
		} 
		else {
			taskName = userTaskName;
		}
	} 
	
	// get task name
	public String getTaskName() {
		return taskName;
	}
	
	// set task description
	public void setTaskDescription(String userTaskDescription) throws Exception {
		if (userTaskDescription == null || userTaskDescription.length() > 50) {
			throw new IllegalArgumentException("Task description invalid");
		} else {
			taskDescription = userTaskDescription;
		}
	}
	// get task description
	public String getTaskDescription() {
		return taskDescription;
	}
}
