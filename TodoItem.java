/**
 * Each task in the todo list
 */
public class TodoItem {
    private String taskName;
    private boolean isDone;


    TodoItem(String taskName) {
        this(taskName, false);
    }

    TodoItem(String taskName, boolean isDone) {
        this.taskName= taskName;
        this.isDone= isDone;
    }


    public String getName() {
        return this.taskName;
    }

    public void setName(String taskName) {
        this.taskName= taskName;
    }


    public boolean taskIsCompleted() {
        return isDone;
    }

    public void toggleTodoCheckedStatus() {
        isDone= !isDone;
    }
}
