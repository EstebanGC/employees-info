package org.example;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

    private static final String URL = "jdbc:mysql://localhost:3307/xxxx";
    private static final String USERNAME = "xxxx";
    private static final String PASSWORD = "xxxx";

    public static int callCountDepartments() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            CallableStatement cs = conn.prepareCall("{CALL COUNT_DEPARTMENTS(?)}");
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.execute();
            return cs.getInt(1);
        }
    }

    public static int callCountEmployees() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            CallableStatement cs = conn.prepareCall("{CALL COUNT_EMPLOYEES(?)}");
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.execute();
            return cs.getInt(1);
        }
    }

    public static int callCountEmployeesByDepartmentId(int departmentId) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            CallableStatement cs = conn.prepareCall("{CALL COUNT_EMPLOYEES_BY_DEPARTMENT_ID(?, ?)}");
            cs.setInt(1, departmentId);
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.execute();
            return cs.getInt(2);
        }
    }
}
