
import java.util.Scanner;

public class TaskUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\n----- Task Management System -----");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. View All Tasks");
        System.out.println("5. View Overdue Tasks");
        System.out.println("6. View Upcoming Tasks");
        System.out.println("7. Search Task");
        System.out.println("8. Sort Tasks by Priority");
        System.out.println("9. Sort Tasks by Due Date");
        System.out.println("10. Edit Task");
        System.out.println("11. View Statistics");
        System.out.println("12. Exit");
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getValidIntInput(String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                if (input < 1 || input > 5) {
                    System.out.println("Priority must be between 1 and 5.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return input;
    }

    public static void showTaskReminders(CustomLinkedList taskList, String todayDate) {
        System.out.println("\n----- Overdue Tasks Reminder -----");
        taskList.displayTasks("overdue", todayDate);
    }

    public static String getCurrentDate() {
        return java.time.LocalDate.now().toString();
    }

    public static String getValidTaskName() {
        String taskName;
        while (true) {
            taskName = getInput("Enter task name: ");
            if (taskName.trim().isEmpty()) {
                System.out.println("Task name cannot be empty.");
            } else {
                break;
            }
        }
        return taskName;
    }

    public static String getValidDate() {
        String dueDate;
        while (true) {
            dueDate = getInput("Enter due date (yyyy-MM-dd): ");
            if (dueDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                break;
            } else {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
        return dueDate;
    }

    public static String getValidCategory() {
        String category;
        while (true) {
            category = getInput("Enter category: ");
            if (category.trim().isEmpty()) {
                System.out.println("Category cannot be empty.");
            } else {
                break;
            }
        }
        return category;
    }
}
