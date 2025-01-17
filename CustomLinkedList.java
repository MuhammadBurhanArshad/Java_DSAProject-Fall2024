public class CustomLinkedList {
    private Node head;

    public void addTask(Task task, Boolean printMessage) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        if (printMessage) {
            System.out.println("\nTask " + task.name + " added successfully");
        }
    }

    public void deleteTask(String taskName) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
    
        if (head.task.name.equalsIgnoreCase(taskName)) {
            head = head.next;
            System.out.println("\nTask '" + taskName + "' deleted successfully!");
            return;
        }
    
        Node current = head;
        while (current.next != null && !current.next.task.name.equalsIgnoreCase(taskName)) {
            current = current.next;
        }
    
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("\nTask '" + taskName + "' deleted successfully!");
        } else {
            System.out.println("\nTask '" + taskName + "' not found!");
        }
    }
    
    public void markTaskAsCompleted(String taskName) {
        Node current = head;
        while (current != null) {
            if (current.task.name.equalsIgnoreCase(taskName)) {
                current.task.isCompleted = true;
                System.out.println("\nTask '" + taskName + "' has been marked as completed");
                return;
            }
            current = current.next;
        }
        System.out.println("\nTask '" + taskName + "' not found");
    }

    public Task searchTask(String taskName) {
        Node current = head;
        while (current != null) {
            if (current.task.name.equalsIgnoreCase(taskName)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void displayTasksByCategory(String category) {
        Node current = head;
        boolean found = false;
    
        System.out.println("\nTasks in category: " + category + "\n");
        while (current != null) {
            if (current.task.category.equalsIgnoreCase(category)) {
                current.task.displayTask();
                found = true;
            }
            current = current.next;
        }
    
        if (!found) {
            System.out.println("No tasks found in the category: " + category);
        }
    }

    public void displayTasks(String filter, String todayDate) {
        Node current = head;
        System.out.println("\n----- Tasks (" + filter + ") ----- \n");

        while (current != null) {
            Task task = current.task;
            boolean showTask = false;

            switch (filter.toLowerCase()) {
                case "overdue":
                    if (!task.isCompleted && compareDates(task.dueDate, todayDate) < 0) {
                        showTask = true;
                    }
                    break;
                case "upcoming":
                    if (!task.isCompleted && compareDates(task.dueDate, todayDate) > 0) {
                        showTask = true;
                    }
                    break;
                case "completed":
                    if (task.isCompleted) {
                        showTask = true;
                    }
                    break;
                case "all":
                    showTask = true;
                    break;
            }

            if (showTask) {
                task.displayTask();
            }

            current = current.next;
        }
    }

    public void sortTasksByPriority() {
        if (head == null || head.next == null) return;

        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = head; j.next != null; j = j.next) {
                if (j.task.priority > j.next.task.priority) {
                    Task temp = j.task;
                    j.task = j.next.task;
                    j.next.task = temp;
                }
            }
        }
    }

    public void sortTasksByDueDate() {
        if (head == null || head.next == null) return;

        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = head; j.next != null; j = j.next) {
                if (compareDates(j.task.dueDate, j.next.task.dueDate) > 0) {
                    Task temp = j.task;
                    j.task = j.next.task;
                    j.next.task = temp;
                }
            }
        }
    }

    public int compareDates(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");

        for (int i = 0; i < 3; i++) {
            int part1 = Integer.parseInt(d1[i]);
            int part2 = Integer.parseInt(d2[i]);
            if (part1 < part2) return -1;
            if (part1 > part2) return 1;
        }
        return 0;
    }

    public void editTask(String taskName, String newName, String newDueDate, String newCategory, int newPriority) {
        Node current = head;
        while (current != null) {
            if (current.task.name.equalsIgnoreCase(taskName)) {
                current.task.name = newName;
                current.task.dueDate = newDueDate;
                current.task.category = newCategory;
                current.task.priority = newPriority;
                return;
            }
            current = current.next;
        }
    }

    public void displayStatistics(String todayDate) {
        int totalTasks = 0, completedTasks = 0, overdueTasks = 0, upcomingTasks = 0;

        Node current = head;
        while (current != null) {
            totalTasks++;
            if (current.task.isCompleted) {
                completedTasks++;
            } else if (compareDates(current.task.dueDate, todayDate) < 0) {
                overdueTasks++;
            } else {
                upcomingTasks++;
            }
            current = current.next;
        }

        System.out.println("=== Task Statistics ===");
        System.out.println("Total Tasks: " + totalTasks);
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Overdue Tasks: " + overdueTasks);
        System.out.println("Upcoming Tasks: " + upcomingTasks);
    }
}
