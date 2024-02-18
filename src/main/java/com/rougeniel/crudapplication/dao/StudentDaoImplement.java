package com.rougeniel.crudapplication.dao;

import com.rougeniel.crudapplication.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(Long id) {
        return entityManger.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManger.createQuery("FROM Student order by lastName asc", Student.class);
//        TypedQuery<Student> listStudentOrderByAsc = entityManger.createQuery("FROM Student order by lastName asc", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create sql query
        TypedQuery<Student> studLastName = entityManger.createQuery("FROM Student WHERE lastName=:theDatas", Student.class);
        //set query param
        studLastName.setParameter("theDatas", lastName);
        //return result
        return studLastName.getResultList();
    }

//    @Transactional uses for updating the data into the database
    @Override
    @Transactional
    public void update(Student student) {
        entityManger.merge(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Student student = entityManger.find(Student.class, id);
        entityManger.remove(student);
    }

}
