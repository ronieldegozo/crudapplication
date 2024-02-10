package com.rougeniel.crudapplication.dao;

import com.rougeniel.crudapplication.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImplement implements StudentDao{

    //define field for entity
    private EntityManager entityManger;

    //inject entity using constructor injection
    @Autowired
    public StudentDaoImplement(EntityManager entityManger) {
        this.entityManger = entityManger;
    }

    //implement save method
    //@Transactional uses when dealing with the databases
    @Override
    @Transactional
    public void save(Student student) {
        entityManger.persist(student);
    }
}
