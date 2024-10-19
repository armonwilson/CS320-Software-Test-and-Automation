package taskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	// Test addNewTask() function
	@Test
	void addNewTaskTest()throws Exception {
		// Create the taskService HashMap
		TaskService taskService = new TaskService();
		// Add task to HashMap
		taskService.addNewTask("0123456789", "task name", "task description");
		// Verify exception argument works.
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			taskService.getTask("012345678");
		});
		// Verify task was added to HashMap
		Task testTask = taskService.getTask("0123456789");
		assertTrue(testTask.getTaskID().equals("0123456789"));
		assertTrue(testTask.getTaskName().equals("task name"));
		assertTrue(testTask.getTaskDescription().equals("task description"));
	}
	
	// Test deleteTask() Function
	@Test
	void deleteTaskTest() throws Exception {
		// Create the taskService HashMap
		TaskService taskService = new TaskService();
		// Create Task to delete
		taskService.addNewTask("0123456789", "task name", "task description");
		// Test exception for invalid task ID 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("123456789");
		});
		// Delete task
		taskService.deleteTask("0123456789");
		// Search for task in HashMap
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.getTask("0123456789");
		});
	}
	
	// Test updateTaskName() function
	@Test
	void updateTaskNameTest()throws Exception {
		// Create the taskService HashMap
		TaskService taskService = new TaskService();
		// Create the task
		taskService.addNewTask("0123456789", "task name", "task description");
		// Test invalid ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskName("012345678", "new Name");
		});
		assertFalse(taskService.getTask("0123456789").getTaskName().equals("new Name"));
		// Verify taskName updates in HashMap
		taskService.updateTaskName("0123456789", "new Name");
		assertTrue(taskService.getTask("0123456789").getTaskName().equals("new Name"));		
	}
	 
	// Test updateDescription() function.
	@Test
	void updateDescriptionTest() throws Exception {
		// Create the taskService HashMap
		TaskService taskService = new TaskService();
		// Create the task
		taskService.addNewTask("0123456789", "task name", "task description");
		// Test invalid ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskDescription("012345678", "new Description");
		});
		assertFalse(taskService.getTask("0123456789").getTaskName().equals("new Description"));
		// Verify taskDescription updates in HashMap
		taskService.updateTaskDescription("0123456789", "new Description");
		assertTrue(taskService.getTask("0123456789").getTaskDescription().equals("new Description"));			
	}
}