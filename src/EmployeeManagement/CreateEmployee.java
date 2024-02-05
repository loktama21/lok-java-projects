package EmployeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateEmployee {

    private Connection connection;

    public CreateEmployee(Connection connection) {
        this.connection = connection;
    }

    public void createEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (first_name, last_name, email, department, salary) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getDepartment());
            preparedStatement.setDouble(5, employee.getSalary());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " employee(s) inserted.");
        }
    }
}
