// (COMMENT/EXPLANATION)

import java.io.*;
  //nag import tayo ng "java.io" (for read and write files)
  
import java.util.*;
    // nag import din tayo ng "java.util" (scanner for input and arraylist naman for storing tasks)

public class SimpleToDoList 
  // public class SimpleToDoList — defines your main class; the name must match your file name.

  static Scanner input = new Scanner(System.in); 
  // to read user input
  
  static ArrayList<String> tasks = new ArrayList<>();
  // list to store tasks
  
  static String fileName = "tasks.txt";
  // name of the file to save tasks

public static void main(String[] args) 
    loadTasks(); 
    // load existing tasks from file when program starts

while (choice != 5) 
  // while loop keeps the menu running until the user chooses option 5 (exit).

            System.out.println("\n======== TO-DO LIST ========");
            System.out.println("||     1. View Tasks      ||");
            System.out.println("||     2. Add Task        ||");
            System.out.println("||     3. Edit Task       ||");
            System.out.println("||     4. Delete Task     ||");
            System.out.println("||     5. Save and Exit   ||");
            System.out.println("============================");
            System.out.print("Enter your choice:    ");
  // this block of code is for displaying menu options (UI/GUI)

choice = input.nextInt();
  // reads a whole number from the user's choice
  
input.nextLine();
  // clear leftover newline so text input works properly next time

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
  //conditions, based sa number na i enter
  1. is for viewTasks
  2. is for addTask
  3. is for editTask
  4. is for deleteTask
  5. is for saveTasks

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
// Shows the list of tasks.
if (tasks.size() == 0) - checks if there are no tasks.
If not empty, it prints each task one by one using a simple for-each loop.

    static void addTask() {
        System.out.print("Enter a new task: ");
        String newTask = input.nextLine();
        tasks.add(newTask);
        System.out.println("Task added!");
    }

//Asks the user to type a new task.
Adds the task to the ArrayList.
Confirms with “Task added!”

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

//Shows current tasks first.
Checks if there are any to edit.
The user chooses which task number to change.
The program replaces that task with the new one using tasks.set(index, newValue).

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

//Displays all tasks.
The user enters a number.
The program removes that task from the list using tasks.remove(index).

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

//FileWriter opens (or creates) a file called tasks.txt.
Each task is written on its own line.
try–catch handles errors, so if something goes wrong (like missing file permissions), the program won’t crash.

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

//Checks if the file tasks.txt exists.
If yes, it reads each line and adds it to the list.
That’s how your tasks “come back” when you reopen the app.
