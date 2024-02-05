package EmployeeManagement;

import EmployeeManagement.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/demo";
    private static final String USER = "student";
    private static final String PASSWORD = "student";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            CreateEmployee createEmployee = new CreateEmployee(connection);
            ReadEmployees readEmployees = new ReadEmployees(connection);
            UpdateEmployeeSalary updateEmployeeSalary = new UpdateEmployeeSalary(connection);
            DeleteEmployee deleteEmployee = new DeleteEmployee(connection);

            // Prompt user for CRUD operation choice
            System.out.println("Choose CRUD operation:");
            System.out.println("1. Create Employee");
            System.out.println("2. Read Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Create Employee
                    System.out.println("Enter first name:");
                    String firstName = scanner.next();
                    System.out.println("Enter last name:");
                    String lastName = scanner.next();
                    System.out.println("Enter email:");
                    String email = scanner.next();
                    System.out.println("Enter department:");
                    String department = scanner.next();
                    System.out.println("Enter salary:");
                    double salary = scanner.nextDouble();
                    createEmployee.createEmployee(new Employee(firstName, lastName, email, department, salary) );
                    break;
                case 2:
                    // Read Employees
                    readEmployees.readEmployees();
                    break;
                case 3:
                    // Update Employee Salary
                    System.out.println("Enter employee ID:");
                    int idToUpdate = scanner.nextInt();
                    System.out.println("Enter new salary:");
                    double newSalary = scanner.nextDouble();
                    updateEmployeeSalary.updateEmployeeSalary(idToUpdate, newSalary);
                    break;
                case 4:
                    // Delete Employee
                    System.out.println("Enter employee ID to delete:");
                    int idToDelete = scanner.nextInt();
                    deleteEmployee.deleteEmployee(idToDelete);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
