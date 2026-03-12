package com.capgi.dao;

import com.capgi.entity.Student;
import com.capgi.repository.StudentRepository;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    StudentRepository repo = new StudentRepository();

    public void save(Student student) {
        repo.save(student);
    }

    public List<Student> fetchAll() {
        return repo.fetchAll();
    }

    public Student fetchById(int id) {
        return repo.fetchById(id);
    }

    public void updateMarks(int id, double marks) {
        repo.updateMarks(id, marks);
    }

    public void delete(int id) {
        repo.delete(id);
    }

    public List<Student> sortByMarks() {
        return repo.sortByMarks();
    }

    public List<Student> sortByAgeDesc() {
        return repo.sortByAgeDesc();
    }

    public List<Student> filterByDept(String dept) {
        return repo.filterByDept(dept);
    }

    public List<Student> nativeFetch() {
        return repo.nativeFetch();
    }

    public void nativeUpdateMarks(int id, double marks) {
        repo.nativeUpdateMarks(id, marks);
    }
}
