package com.capg.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class PlayerRepo {
public static Connection getConnection(){
    try{
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Gaming",
                "postgres",
                "12345"
        );
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}
}
