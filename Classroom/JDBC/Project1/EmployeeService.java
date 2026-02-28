package packing;

import java.sql.CallableStatement;
import java.sql.Connection;

public class EmployeeService {

    public void insertEmployee(  int id,String name, double salary) {

        String sql = "CALL insert_employee(?, ?,?)"; // PostgreSQL procedure

        try (Connection conn = DatabaseUtil.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1,id);

            stmt.setString(2, name);
            stmt.setDouble(3, salary);

            stmt.execute();

            System.out.println("Employee inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
