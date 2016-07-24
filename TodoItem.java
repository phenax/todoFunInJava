/**
 * Each task in the todo list
 *
 * @author Akshay Nair<phenax5@gmail.com>
 */
public class TodoItem {

    // Name of the task(identifier)
    private String taskName;

    // The checked state of the task
    private boolean isDone;


    // constructor(String)
    TodoItem(String taskName) {
        
        // Create todo item with the default checked state of false
        this(taskName, false);
    }

    // constructor(String, boolean)
    TodoItem(String taskName, boolean isDone) {
        this.taskName= taskName;
        this.isDone= isDone;
    }


    // taskName getter
    public String getName() {
        return this.taskName;
    }

    // taskName setter
    public void setName(String taskName) {
        this.taskName= taskName;
    }


    // isDone getter
    public boolean getTaskCheckedState() {
        return isDone;
    }

    // isDone setter
    public void setTaskCheckedState(boolean isDone) {
        this.isDone= isDone;
    }

    // Toggle the value of isDone
    public void toggleTodoCheckedStatus() {
        this.setTaskCheckedState(!this.getTaskCheckedState());
    }
}
