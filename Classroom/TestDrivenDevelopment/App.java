package org.example;

public class App {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        System.out.println("Addition: " + calc.add(5, 3));

        StringProcessor sp = new StringProcessor();
        System.out.println("Concat: " + sp.concatenate("Hello ", "World"));

        System.out.println("Palindrome: " + sp.isPalindrome("madam"));
    }
}
