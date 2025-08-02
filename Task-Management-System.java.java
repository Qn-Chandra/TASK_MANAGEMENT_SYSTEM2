import java.util.*;

class Task {
    private static int idCounter = 1;
    private int id;
    private String title;
    private boolean isCompleted;

    public Task(String title) {
        this.id = idCounter++;
        this.title = title;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return id + ". " + title + (isCompleted ? " [Completed]" : " [Pending]");
    }
}

public class TaskManager {
    private static List<Task> taskList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskCompleted();
                case 4 -> deleteTask();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private static void showMenu() {
        System.out.println("\n--- Task Management System ---");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        taskList.add(new Task(title));
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("\nYour Tasks:");
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }

    private static void markTaskCompleted() {
        System.out.print("Enter task ID to mark as completed: ");
        int id = sc.nextInt();
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.markCompleted();
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = sc.nextInt();
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                System.out.println("Task deleted successfully.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }
}
