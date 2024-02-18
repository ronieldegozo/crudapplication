package com.rougeniel.crudapplication.dao;

import com.rougeniel.crudapplication.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);

    Student findById(Long id);
    List<Student> findAll();

    List<Student> findByLastName(String lastName);


}
