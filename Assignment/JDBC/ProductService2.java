package jdbc;

import java.sql.*;
import java.util.*;

public class ProductService2 {

    public static void updateProductPrice(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();

            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("UPDATE products SET price=" + price + " WHERE product_id=" + id);

            System.out.println(rows > 0 ? "Price Updated" : "Product Not Found");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateProductStock(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Quantity Change: ");
            int qty = sc.nextInt();

            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("UPDATE products SET quantity = quantity + " + qty + " WHERE product_id=" + id);

            System.out.println(rows > 0 ? "Stock Updated" : "Product Not Found");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteProduct(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("DELETE FROM products WHERE product_id=" + id);

            System.out.println(rows > 0 ? "Product Deleted" : "Product Not Found");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
