package app;

import dao.ProductDAO;
import model.Product;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while(true){

            System.out.println("\n PRODUCT INVENTORY MENU ");
            System.out.println("1 Add Product");
            System.out.println("9 Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1:

                    System.out.println("Enter ID");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name");
                    String name = sc.nextLine();

                    System.out.println("Enter Category");
                    String cat = sc.nextLine();

                    System.out.println("Enter Price");
                    double price = sc.nextDouble();

                    System.out.println("Enter Quantity");
                    int qty = sc.nextInt();

                    System.out.println("Enter Rating");
                    double rating = sc.nextDouble();

                    Product p = new Product(id,name,cat,price,qty,rating);

                    dao.addProduct(p);

                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}