package com.capgi.main;

import com.capgi.dao.StudentDAO;
import com.capgi.dao.StudentDAOImpl;
import com.capgi.entity.Student;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

        Student s1 = new Student("Rahul", 21, "CSE", 85);
        Student s2 = new Student("Aman", 22, "IT", 90);

        dao.save(s1);
        dao.save(s2);

        System.out.println("All Students:");
        dao.fetchAll().forEach(s ->
                System.out.println(s.getName() + " " + s.getMarks())
        );

        dao.updateMarks(1, 95);

        dao.delete(2);
    }
}
