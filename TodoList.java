/**
 * A list of all the todo items
 */
public class TodoList {
    private final int MAX_TODO_ITEMS= 20;

    private TodoItem[] todoList;
    private int numberOfTodos= 0;

    TodoList() {
        todoList= new TodoItem[MAX_TODO_ITEMS];
    }


    private void partitionTasks() {
        TodoItem temp;
        for(int i= 0; i< numberOfTodos; i++) {
            if(todoList[i].taskIsCompleted()) {

            }
        }
    }

    public void addTask(String name) throws TodoListOverFlowException {
        if(numberOfTodos >= MAX_TODO_ITEMS)
            throw new TodoListOverFlowException("No more space left for tasks. Delete a few to continue.");

        todoList[numberOfTodos++]= new TodoItem(name);
    }

    public void toggleCheckState(String name) {
        for(int i= 0; i< numberOfTodos; i++)
            if(todoList[i].getName() == name)
                todoList[i].toggleTodoCheckedStatus();

        partitionTasks();
    }

    public void printAllTasks() {
        for(int i= numberOfTodos - 1; i>= 0; i--) {
            System.out.println(todoList[i].getName() + "\t" + todoList[i].taskIsCompleted());
        }
    }
}
