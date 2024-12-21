
public class CustomExceptions {

    public static class TaskNotFoundException extends Exception {
        public TaskNotFoundException(String taskName) {
            super("Task with name '" + taskName + "' not found.");
        }
    }
}
