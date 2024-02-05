package TodoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/todo";
    private static final String USER = "student";
    private static final String PASSWORD = "student";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            TaskDAO taskDAO = new TaskDAOImpl(connection);
            Scanner scanner = new Scanner(System.in);

            boolean exit = false;

            while(!exit) {
                System.out.println("Select from following options: ");
                System.out.println("1. Create a new task.");
                System.out.println("2. Update a current task.");
                System.out.println("3. Delete a task.");
                System.out.println("4. Read all tasks.");
                System.out.println("5. Exit.\n");
                System.out.print("Enter the option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Enter the task: ");
                        String newTask = scanner.nextLine();
                        System.out.print("Enter the assigned person name: ");
                        String assignedPerson = scanner.nextLine();
                        System.out.print("Enter the number of days to complete the task: ");
                        int daysToComplete = scanner.nextInt();
                        taskDAO.createTask(new Task(newTask, assignedPerson, daysToComplete));
                        break;
                    case 2:
                        System.out.print("Enter task id to update task: ");
                        int idForUpdate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter a new task description: ");
                        String updatedTask = scanner.nextLine();
                        taskDAO.updateTask(idForUpdate, updatedTask);
                        break;
                    case 3:
                        System.out.print("Enter task id to delete task: ");
                        int idForDelete = scanner.nextInt();
                        taskDAO.deleteTask(idForDelete);
                        break;
                    case 4:
                        List<Task> tasks = taskDAO.getAllTasks();
                        System.out.println();
                        for(Task task: tasks){
                            System.out.println(task.getId() + ", " +
                                    task.getDescription() + ", " +
                                    task.getAssignedPerson() + ", " +
                                    task.getDaysToComplete());
                        }
                        System.out.println();
                        break;
                    case 5:
                        exit =  true;
                        System.out.println("Bye Player!");
                        break;
                    default:
                        System.out.println("Invalid input \n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
