package jdbc;

import java.sql.*;
import java.util.*;

public class ProductApp {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            while (true) {

                System.out.println("\n1 Add Product");
                System.out.println("2 View All");
                System.out.println("3 View By ID");
                System.out.println("4 Update Price");
                System.out.println("5 Update Stock");
                System.out.println("6 Delete");
                System.out.println("7 Exit");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> ProductService1.addProduct(con, sc);
                    case 2 -> ProductService1.viewAllProducts(con);
                    case 3 -> ProductService1.viewProductById(con, sc);
                    case 4 -> ProductService2.updateProductPrice(con, sc);
                    case 5 -> ProductService2.updateProductStock(con, sc);
                    case 6 -> ProductService2.deleteProduct(con, sc);
                    case 7 -> {
                        System.out.println("Exiting Application");
                        return;
                    }
                    default -> System.out.println("Invalid Choice");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
