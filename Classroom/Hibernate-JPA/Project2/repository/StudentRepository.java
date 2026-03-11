package com.capgi.repository;

import com.capgi.entity.Student;
import jakarta.persistence.*;
import java.util.List;

public class StudentRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
    EntityManager em = emf.createEntityManager();

    public void save(Student student) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
    }

    public List<Student> fetchAll() {
        return em.createQuery("FROM Student", Student.class).getResultList();
    }

    public Student fetchById(int id) {
        return em.find(Student.class, id);
    }

    public void updateMarks(int id, double marks) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student s = em.find(Student.class, id);
        if (s != null) {
            s.setMarks(marks);
        }
        tx.commit();
    }

    public void delete(int id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student s = em.find(Student.class, id);
        if (s != null) {
            em.remove(s);
        }
        tx.commit();
    }

    public List<Student> sortByMarks() {
        return em.createQuery("FROM Student ORDER BY marks", Student.class).getResultList();
    }

    public List<Student> sortByAgeDesc() {
        return em.createQuery("FROM Student ORDER BY age DESC", Student.class).getResultList();
    }

    public List<Student> filterByDept(String dept) {
        return em.createQuery("FROM Student WHERE dept = :d", Student.class)
                .setParameter("d", dept)
                .getResultList();
    }

    public List<Student> nativeFetch() {
        return em.createNativeQuery("SELECT * FROM student", Student.class).getResultList();
    }

    public void nativeUpdateMarks(int id, double marks) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createNativeQuery("UPDATE student SET marks=? WHERE id=?")
                .setParameter(1, marks)
                .setParameter(2, id)
                .executeUpdate();
        tx.commit();
    }
}
