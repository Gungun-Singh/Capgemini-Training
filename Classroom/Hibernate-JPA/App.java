package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        // Create object
        Person pr = new Person();
        pr.setId(3094);
        pr.setName("Nazz");

        // Hibernate configuration
        Configuration configuration = new Configuration()
                .configure() // loads hibernate.cfg.xml
                .addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // Save object
        session.persist(pr);

        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println("Data inserted successfully!");
    }
}
