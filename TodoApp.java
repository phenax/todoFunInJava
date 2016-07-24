import java.util.Scanner;

/**
 * A todo app that lets your manage your tasks
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
            System.out.println("1 - Add a new task");
            System.out.println("2 - Check completed task");
            System.out.print("Enter your choice : ");

            option= userInput.nextInt();

            try {
                switch(option) {
                    case 1:
                        System.out.println("Enter the name of the task : ");
                        todoList.addTask(userInput.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter the name of the task : ");
                        todoList.toggleCheckState(userInput.nextLine());
                        break;
                    default:
                        System.out.println("\nChoose from the options your have motherfucker");
                }
            } catch(TodoListOverFlowException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
