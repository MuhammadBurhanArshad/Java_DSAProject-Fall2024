public class Task {
    String name;
    String dueDate;
    String category;
    int priority; 
    boolean isCompleted;

    public Task(String name, String dueDate, String category, int priority, boolean isCompleted) {
        this.name = name;
        this.dueDate = dueDate;
        this.category = category;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    public void displayTask() {
        System.out.println("Task: " + name + " | Due Date: " + dueDate + " | Category: " + category +
                " | Priority: " + priority + " | Status: " + (isCompleted ? "Completed" : "Pending"));
    }
}
