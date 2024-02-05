package TodoList;

import java.util.List;

public interface TaskDAO {
    void createTask(Task task);
    void updateTask(int id, String newTask);
    void deleteTask(int id);

    List<Task> getAllTasks();
}
