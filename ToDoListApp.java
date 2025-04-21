import java.util.ArrayList;
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
    private static ArrayList<Task<String>> tasks = new ArrayList<>();
    
    public static void addTask(String title, String description) {
        tasks.add(new Task<>(title, description));
        System.out.println("Task added successfully.");
    }
    public static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
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
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    addTask(title, description);
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}