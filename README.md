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

public static void main(String[] args) {
    loadTasks(); 
    // load existing tasks from file when program starts

while (choice != 5) {
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









