package jdbc;

import java.sql.*;
import java.util.*;

public class ProductService1 {

    public static void addProduct(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products WHERE product_id=" + id);

            if (rs.next()) {
                System.out.println("Product ID already exists");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Category: ");
            String category = sc.next();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();
            System.out.print("Enter Rating: ");
            double rating = sc.nextDouble();
            System.out.print("Enter Manufacturer: ");
            String manufacturer = sc.next();

            String sql = "INSERT INTO products(product_id,product_name,category,price,quantity,rating,manufacturer) VALUES("
                    + id + ",'" + name + "','" + category + "'," + price + "," + quantity + "," + rating + ",'" + manufacturer + "')";

            int rows = stmt.executeUpdate(sql);
            System.out.println(rows > 0 ? "Product Added Successfully" : "Insert Failed");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewAllProducts(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            int count = 0;
            while (rs.next()) {
                count++;
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | "
                        + rs.getString(3) + " | " + rs.getDouble(4) + " | "
                        + rs.getInt(5) + " | " + rs.getDouble(6));
            }

            if (count == 0)
                System.out.println("No products found");
            else
                System.out.println("Total Records: " + count);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewProductById(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products WHERE product_id=" + id);

            if (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | "
                        + rs.getString(3) + " | " + rs.getDouble(4) + " | "
                        + rs.getInt(5) + " | " + rs.getDouble(6));
            } else {
                System.out.println("Product does not exist");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
