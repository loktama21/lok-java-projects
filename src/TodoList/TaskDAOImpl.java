package TodoList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    private Connection connection;

    public TaskDAOImpl(Connection conn) {
        this.connection = conn;
    }

    @Override
    public void createTask(Task task) {
        String sql = "INSERT INTO tasks (task_description, task_assigned_person, task_complettion_days) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, task.getDescription());
            preparedStatement.setString(2, task.getAssignedPerson());
            preparedStatement.setInt(3, task.getDaysToComplete());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " task added. \n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateTask(int id, String newTask){
        String sql = "UPDATE tasks SET task_description = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, newTask);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " rows updated. \n");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void deleteTask(int id){
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " rows deleted. \n");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String description = resultSet.getString("task_description");
                String assignedPerson = resultSet.getString("task_assigned_person");
                int daysToComplete = resultSet.getInt("task_complettion_days");
                Task task = new Task(id, description, assignedPerson, daysToComplete);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

}
