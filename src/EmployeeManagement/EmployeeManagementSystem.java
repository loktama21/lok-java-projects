//import java.sql.*;
//
//public class EmployeeManagementSystem {
//
//    // JDBC URL, username, and password of MySQL server
//    private static final String URL = "jdbc:mysql://localhost:3306/demo";
//    private static final String USER = "student";
//    private static final String PASSWORD = "student";
//
//    // JDBC variables for opening, closing, and managing connection
//    private static Connection connection;
//    private static Statement statement;
//    private static ResultSet resultSet;
//
//    public static void main(String[] args) {
//        try {
//            // Connect to MySQL database
//            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//
//            // Create a statement
//            statement = connection.createStatement();
//
//            // Perform CRUD operations
//            // Create
//            createEmployee("John", "Doe", "john.doe@example.com", "IT", 50000);
//
//            // Read
//            readEmployees();
//
//            // Update
//            updateEmployeeSalary(1, 60000);
//
//            // Read again to see the changes
//            readEmployees();
//
//            // Delete
//            deleteEmployee(1);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Close the connections
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // Create Employee
//    private static void createEmployee(String firstName, String lastName, String email, String department, double salary) throws SQLException {
//        String sql = "INSERT INTO employees (first_name, last_name, email, department, salary) VALUES (?, ?, ?, ?, ?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, firstName);
//        preparedStatement.setString(2, lastName);
//        preparedStatement.setString(3, email);
//        preparedStatement.setString(4, department);
//        preparedStatement.setDouble(5, salary);
//        int rowsAffected = preparedStatement.executeUpdate();
//        System.out.println(rowsAffected + " employee(s) inserted.");
//    }
//
//    // Read Employees
//    private static void readEmployees() throws SQLException {
//        String sql = "SELECT * FROM employees";
//        resultSet = statement.executeQuery(sql);
//        while (resultSet.next()) {
//            System.out.println(
//                    resultSet.getInt("id") + ", " +
//                            resultSet.getString("first_name") + ", " +
//                            resultSet.getString("last_name") + ", " +
//                            resultSet.getString("email") + ", " +
//                            resultSet.getString("department") + ", " +
//                            resultSet.getDouble("salary")
//            );
//        }
//    }
//
//    // Update Employee Salary
//    private static void updateEmployeeSalary(int id, double newSalary) throws SQLException {
//        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setDouble(1, newSalary);
//        preparedStatement.setInt(2, id);
//        int rowsAffected = preparedStatement.executeUpdate();
//        System.out.println(rowsAffected + " employee(s) updated.");
//    }
//
//    // Delete Employee
//    private static void deleteEmployee(int id) throws SQLException {
//        String sql = "DELETE FROM employees WHERE id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, id);
//        int rowsAffected = preparedStatement.executeUpdate();
//        System.out.println(rowsAffected + " employee(s) deleted.");
//    }
//}
