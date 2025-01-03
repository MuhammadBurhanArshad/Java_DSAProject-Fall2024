public class TaskManagementSystem {

    public static void main(String[] args) {
        CustomLinkedList taskList = new CustomLinkedList();
        String todayDate = TaskUtils.getCurrentDate();

        taskList.addTask(new Task("Complete Assignment", "2024-12-25", "School", 1, false), false);
        taskList.addTask(new Task("Prepare for Exam", "2024-12-22", "School", 2, false), false);
        taskList.addTask(new Task("Buy Groceries", "2024-12-20", "Personal", 3, false), false);
        taskList.addTask(new Task("Attend Meeting", "2024-12-15", "Work", 2, true), false);

        while (true) {
            TaskUtils.showMenu();
            int choice = TaskUtils.getValidIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    String taskName = TaskUtils.getValidTaskName();
                    String dueDate = TaskUtils.getValidDate();
                    String category = TaskUtils.getValidCategory();
                    int priority = TaskUtils.getValidIntInput("Enter task priority (1-5): ");
                    taskList.addTask(new Task(taskName, dueDate, category, priority, false), true);
                    break;

                case 2:
                    taskName = TaskUtils.getInput("Enter task name to delete: ");
                    taskList.deleteTask(taskName);
                    break;

                case 3:
                    taskName = TaskUtils.getInput("Enter task name to mark as completed: ");
                    taskList.markTaskAsCompleted(taskName);
                    break;

                case 4:
                    taskList.displayTasks("all", todayDate);
                    break;

                case 5:
                    taskList.displayTasks("overdue", todayDate);
                    break;

                case 6:
                    taskList.displayTasks("upcoming", todayDate);
                    break;

                case 7:
                    taskName = TaskUtils.getInput("Enter task name to search: ");
                    Task task = taskList.searchTask(taskName);
                    if (task != null) {
                        task.displayTask();
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 8:
                    taskList.sortTasksByPriority();
                    System.out.println("Tasks sorted by priority.");

                    taskList.displayTasks("all", todayDate);
                    break;

                case 9:
                    taskList.sortTasksByDueDate();
                    System.out.println("Tasks sorted by due date.");

                    taskList.displayTasks("all", todayDate);
                    break;

                case 10:
                    taskList.displayStatistics(todayDate);
                    break;

                case 11:
                    System.out.println("Exiting program...");
                    return;
            }
        }
    }
}
