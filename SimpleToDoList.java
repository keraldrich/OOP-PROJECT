import java.io.*; // lets us read and write files
import java.util.*; // lets us use Scanner and ArrayList

public class SimpleToDoList {

    static Scanner input = new Scanner(System.in); // to read user input
    static ArrayList<String> tasks = new ArrayList<>(); // list to store tasks
    static String fileName = "tasks.txt"; // name of the file to save tasks

    public static void main(String[] args) {
        loadTasks(); // load existing tasks from file when program starts

        int choice = 0;

        // repeat menu until user chooses to exit
        while (choice != 5) {
            System.out.println("\n======== TO-DO LIST ========");
            System.out.println("||     1. View Tasks      ||");
            System.out.println("||     2. Add Task        ||");
            System.out.println("||     3. Edit Task       ||");
            System.out.println("||     4. Delete Task     ||");
            System.out.println("||     5. Save and Exit   ||");
            System.out.println("============================");
            System.out.print("Enter your choice:    ");


            input.nextLine(); // clear leftover newline

            // choose what to do
            if (choice == 1) {
                viewTasks();
            } else if (choice == 2) {
                addTask();
            } else if (choice == 3) {
                editTask();
            } else if (choice == 4) {
                deleteTask();
            } else if (choice == 5) {
                saveTasks();
                System.out.println("All tasks saved. Goodbye!");
            } else {
                System.out.println("Invalid option! Try again.");
            }
        }
    }

    // show all tasks
    static void viewTasks() {
        System.out.println("\n======== YOUR TASKS ========");

        if (tasks.size() == 0) {
            System.out.println("No tasks yet!");
        } else {
            int number = 1;
            for (String task : tasks) {
                System.out.println(number + ". " + task);
                number++;
            }
        }
    }

    // add a new task
    static void addTask() {
        System.out.print("Enter a new task: ");
        String newTask = input.nextLine();
        tasks.add(newTask);
        System.out.println("Task added!");
    }

    // edit a task
    static void editTask() {
        viewTasks();
        if (tasks.size() == 0)
            return; // no tasks to edit

        System.out.print("Enter the number of the task to edit: ");
        int num = input.nextInt();
        input.nextLine(); // clear newline

        if (num > 0 && num <= tasks.size()) {
            System.out.print("Enter the new task name: ");
            String updatedTask = input.nextLine();
            tasks.set(num - 1, updatedTask);
            System.out.println("Task updated!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    // delete a task
    static void deleteTask() {
        viewTasks();
        if (tasks.size() == 0)
            return; // no tasks to delete

        System.out.print("Enter the number of the task to delete: ");
        int num = input.nextInt();
        input.nextLine(); // clear newline

        if (num > 0 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Task deleted!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    // save all tasks to file
    static void saveTasks() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (String task : tasks) {
                writer.write(task + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks!");
        }
    }

    // load all tasks from file
    static void loadTasks() {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    tasks.add(line);
                }
                fileReader.close();
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks!");
        }
    }
}




