package taskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class TaskTest {

	@Test
	void createTaskTest() throws Exception {
		Task task = new Task("1234567890", "task name", "task description");
		assertTrue(task.getTaskID().equals("1234567890"));
		assertTrue(task.getTaskName().equals("task name"));
		assertTrue(task.getTaskDescription().equals("task description"));
	}
	
	@Test
	void nullTasksTest() throws Exception {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "task name", "task description");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", null, "task description");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "task name", null);
			});
	}
	
	@Test
	void taskLongTest() throws Exception {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678910", "task name", "task description");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "This is greater than 20 charactors", "task description");
			});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "task name", "This will be a really long task description that is hopefully longer than 30 charactors.");
			});
	}
}
