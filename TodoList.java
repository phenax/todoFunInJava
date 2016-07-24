

/**
 * A list of all the todo items
 *
 * @author Akshay Nair<phenax5@gmail.com>
 */
public class TodoList {

    // Maximum number of todo items allowed
    private final int MAX_TODO_ITEMS= 20;

    // The array of lists
    private TodoItem[] todoList;

    // The current number of todos in the array
    private int numberOfTodos= 0;


    // constructor
    TodoList() {
        todoList= new TodoItem[MAX_TODO_ITEMS];
    }



    /**
     * Partition the array as checked and unchecked
     */
    private void partitionTasks() {
        int i, j;
        TodoItem temp;

        // Just bubble-sorting it {with the filter as the checked state of todo}
        // TODO: Maybe some other sorting algorithm?
        for(i= 0; i< numberOfTodos - 1; i++) {
            for(j= 0; j< numberOfTodos - i - 1; j++) {
                if(!todoList[j].getTaskCheckedState()) {
                    temp= todoList[j];
                    todoList[j]= todoList[j + 1];
                    todoList[j + 1]= temp;
                }
            }
        }
    }



    /**
     * Add a new task to the todo array
     *
     * @param name The name of the new todo item
     */
    public void addTask(String name) throws TodoListOverFlowException {

        // More than maximum size of array
        if(numberOfTodos >= MAX_TODO_ITEMS)
            throw new TodoListOverFlowException("No more space left for tasks. Delete a few to continue.");

        // Create new todo
        todoList[numberOfTodos++]= new TodoItem(name);
    }


    /**
     * Toggle the checked state of the todo item
     *
     * @param name  The name of the todo item
     */
    public void toggleCheckState(String name) {
        boolean found= false;

        // Search for the name in the list
        for(int i= 0; i< numberOfTodos; i++)
            if(name.equals(todoList[i].getName()) && (found= true))
                todoList[i].toggleTodoCheckedStatus();

        // If item matching the name wasn't found
        if(!found)
            System.out.println("Couldn't find todo item");

        // Partition the array into unchecked and checked
        partitionTasks();
    }


    /**
     * Deletes a task from the array
     *
     * @param name The name of the task to delete
     */
    public void deleteTodoItem(String name) {
        int i, j;
        boolean found= false;

        // Search for the name in the list
        for(i= 0; i< numberOfTodos; i++) {

            // If task found
            if(name.equals(todoList[i].getName())) {

                j= i;

                while(j < numberOfTodos - 1) {
                    todoList[j]= todoList[j + 1];
                    j++;
                }

                numberOfTodos--;

                // Item found
                found= true;

                break;
            }
        }


        // If item matching the name wasn't found
        if(!found)
            System.out.println("Couldn't find todo item");
    }




    /**
     * Print out all the task items
     */
    public void printAllTasks() {
        String checkBox;

        System.out.println("\n- Task list("+ numberOfTodos +") -");

        for(int i= numberOfTodos - 1; i>= 0; i--) {
            checkBox= "[" + ((todoList[i].getTaskCheckedState())? "*": " ") + "]";
            System.out.println(checkBox + " " + todoList[i].getName());
        }

        System.out.println("----------------\n");
    }
}
