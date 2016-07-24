import java.util.Scanner;
import java.io.IOException;

/**
 * A todo app that lets your manage your tasks
 *
 * @author Akshay Nair<phenax5@gmail.com>
 */
public class TodoApp {
    private static Scanner userInput;

    private static TodoList todoList;

    public static void main(String[] args) {
        int option;
        todoList= new TodoList();
        userInput= new Scanner(System.in);

        System.out.println("# Welcome to todo awesomeness #\n");

        while(true) {
            todoList.printAllTasks();

            System.out.println("1 - Add a new task");
            System.out.println("2 - Check/uncheck a task");
            System.out.println("3 - Delete a task");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice : ");

            option= userInput.nextInt();

            System.out.println();
            userInput.nextLine();

            try {

                switch(option) {
                    case 1:
                        System.out.print("Enter the name of the task : ");
                        todoList.addTask(userInput.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter the name of the task : ");
                        todoList.toggleCheckState(userInput.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter the name of the task to delete : ");
                        todoList.deleteTodoItem(userInput.nextLine());
                        break;
                    case 4:
                        System.out.println("Bye bye");
                        return;
                    default:
                        System.out.println("\nChoose from the options your have motherfucker");
                }
            } catch(TodoListOverFlowException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
