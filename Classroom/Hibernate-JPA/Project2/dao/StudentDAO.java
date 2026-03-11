
package com.capgi.dao;

public interface StudentDAO {
    void save(com.capgi.entity.Student student);

    java.util.List<com.capgi.entity.Student> fetchAll();

    com.capgi.entity.Student fetchById(int i);

    void updateMarks(int i, double v);

    void delete(int i);

    java.util.List<com.capgi.entity.Student> sortByMarks();

    java.util.List<com.capgi.entity.Student> sortByAgeDesc();

    java.util.List<com.capgi.entity.Student> filterByDept(java.lang.String s);

    java.util.List<com.capgi.entity.Student> nativeFetch();

    void nativeUpdateMarks(int i, double v);
}
