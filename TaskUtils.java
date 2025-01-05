import java.util.Scanner;

public class TaskUtils {

    public static void showMenu() {
        System.out.println("\n==== Task Management System ====");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. View All Tasks");
        System.out.println("5. View Overdue Tasks");
        System.out.println("6. View Upcoming Tasks");
        System.out.println("7. Search Task");
        System.out.println("8. Sort Tasks by Priority");
        System.out.println("9. Sort Tasks by Due Date");
        System.out.println("10. View Statistics");
        System.out.println("11. View by Category");
        System.out.println("12. Exit");
    }

    public static int getValidIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 12) {
                    return input;
                } else {
                    System.out.println("Invalid option, please choose between 1 and 12.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }
    }

    public static String getValidTaskName() {
        Scanner scanner = new Scanner(System.in);
        String taskName;
        while (true) {
            System.out.print("Enter task name: ");
            taskName = scanner.nextLine();
            if (!taskName.trim().isEmpty()) {
                return taskName;
            } else {
                System.out.println("Task name cannot be empty.");
            }
        }
    }

    public static String getValidDate() {
        Scanner scanner = new Scanner(System.in);
        String date;
        while (true) {
            System.out.print("Enter task due date (yyyy-mm-dd): ");
            date = scanner.nextLine();
            if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return date;
            } else {
                System.out.println("Invalid date format, please use yyyy-mm-dd.");
            }
        }
    }

    public static String getValidCategory() {
        Scanner scanner = new Scanner(System.in);
        String category;
        while (true) {
            System.out.print("Enter task category: ");
            category = scanner.nextLine();
            if (!category.trim().isEmpty()) {
                return category;
            } else {
                System.out.println("Category cannot be empty.");
            }
        }
    }

    public static String getCurrentDate() {
        return "2024-12-31"; // Hardcoded for simplicity
    }

    public static String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
