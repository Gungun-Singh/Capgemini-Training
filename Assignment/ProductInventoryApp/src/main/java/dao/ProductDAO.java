package dao;

import model.Product;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {

    public void addProduct(Product p) {

        String sql = "INSERT INTO products(product_id,product_name,category,price,quantity,rating) VALUES(?,?,?,?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setString(3, p.getCategory());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getQuantity());
            ps.setDouble(6, p.getRating());

            ps.executeUpdate();

            System.out.println("Product added successfully!");

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}