package EmployeeManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEmployees {

    private Connection connection;

    public ReadEmployees(Connection connection) {
        this.connection = connection;
    }

    public void readEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt("id") + ", " +
                                resultSet.getString("first_name") + ", " +
                                resultSet.getString("last_name") + ", " +
                                resultSet.getString("email") + ", " +
                                resultSet.getString("department") + ", " +
                                resultSet.getDouble("salary")
                );
            }
        }
    }
}
