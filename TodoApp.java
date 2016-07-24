import java.util.Scanner;

/**
 * A todo app that lets your manage your tasks
 *
 * @author Akshay Nair<phenax5@gmail.com>
 */
public class TodoApp {
    // input stream wrapper
    private static Scanner userInput;

    // Array of tasks
    private static TodoList todoList;

    /**
     * Prints all the available options details
     */
    private static void printAllOptions() {
        System.out.println("1 - Add a new task");
        System.out.println("2 - Check/uncheck a task");
        System.out.println("3 - Delete a task");
        System.out.println("4 - Exit");
    }

    // main
    public static void main(String[] args) {
        int option;

        todoList= new TodoList();
        userInput= new Scanner(System.in);

        // Title of program
        System.out.println("# Welcome to todo awesomeness #\n");

        while(true) {
            // Print all todo items
            todoList.printAllTasks();

            // Print all options
            printAllOptions();

            // Input from user for option
            System.out.print("Enter your choice : ");
            option= userInput.nextInt();

            // Leave a line
            System.out.println();

            // Flush last line from System.in
            userInput.nextLine();

            try {
                // All options
                switch(option) {

                    // Add a new task
                    case 1:
                        System.out.print("Enter the name of the task : ");
                        todoList.addTask(userInput.nextLine());
                        break;

                    // Toggle checked state of task
                    case 2:
                        System.out.print("Enter the name of the task : ");
                        todoList.toggleCheckState(userInput.nextLine());
                        break;

                    // Delete a task
                    case 3:
                        System.out.print("Enter the name of the task to delete : ");
                        todoList.deleteTodoItem(userInput.nextLine());
                        break;

                    // Exit out of the program
                    case 4:
                        System.out.println("Bye bye");
                        return;
                    default:
                        System.out.println("\nChoose from the options your have motherfucker");
                }

            } catch(TodoListOverFlowException e) {

                // Print the exception message
                System.out.println(e.getMessage());
            }
        }
    }
}
