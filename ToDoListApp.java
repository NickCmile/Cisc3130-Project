import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Task<E> {
    private E title;
    private E description;

    public Task(E title, E description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return title + " - " + description;
    }
}

public class ToDoListApp {
    private static HashMap<String, ArrayList<Task>> taskMap = new HashMap<>();

    public static void addTask(String category, String title, String description) {
        Task newTask = new Task(title, description);
        taskMap.putIfAbsent(category, new ArrayList<>());
        taskMap.get(category).add(newTask);
        System.out.println("Task added under category: " + category);
    }

    public static void displayTasks() {
        if (taskMap.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (String category : taskMap.keySet()) {
            System.out.println("\nCategory: " + category);
            ArrayList<Task> tasks = taskMap.get(category);
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(" " + (i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    addTask(category, title, description);
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}