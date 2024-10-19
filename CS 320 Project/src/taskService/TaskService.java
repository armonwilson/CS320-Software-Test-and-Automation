package taskService;

import java.util.HashMap;

public class TaskService {
	
	HashMap <String, Task> tasks = new HashMap<>();
	
	public void addNewTask(String newTaskID, String newTaskName, String newTaskDescription) throws Exception {
		Task newTask = new Task(newTaskID, newTaskName, newTaskDescription);
		tasks.put(newTask.getTaskID(), newTask);
	}
	
	// Get Task from HashMap
	public Task getTask(String taskID) throws Exception {
		if (tasks.containsKey(taskID)) {
			return tasks.get(taskID);
		} else {
			throw new IllegalArgumentException(taskID + " not found.");
		}
	}
	
	// delete task by ID from the HashMap
	public void deleteTask(String taskID)throws Exception {
		if (tasks.containsKey(taskID)) {
			tasks.remove(taskID);  
		} else {
			throw new IllegalArgumentException(taskID + " does not exist.");
		}
	}
	
	// update task name
	public void updateTaskName(String taskID, String newName) throws Exception {
		if (tasks.containsKey(taskID)) {
			tasks.get(taskID).setTaskName(newName);
		} else {
			throw new IllegalArgumentException(taskID + " does not exist.");
		}
	}
	
	// update task description
	public void updateTaskDescription(String taskID, String newDescription) throws Exception {
		if (tasks.containsKey(taskID)) {
			tasks.get(taskID).setTaskDescription(newDescription);
		} else {
			throw new IllegalArgumentException(taskID + " does not exist.");
		}
	}
}
