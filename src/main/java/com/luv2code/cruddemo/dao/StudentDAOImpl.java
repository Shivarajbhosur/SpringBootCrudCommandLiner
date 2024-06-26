package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO
        {
            //define fiel for entity manager
            private EntityManager entityManager;

            //define constructur injedction inject enttity manager
            @Autowired
            public StudentDAOImpl(EntityManager entityManager)
            {
                this.entityManager = entityManager;
            }
            //implemet savw method
            @Override
            @Transactional
            public void save(Student thestudent) {
                entityManager.persist(thestudent);

            }

            @Override
            public Student findById(Integer id) {

                return  entityManager.find(Student.class, id);
            }

            @Override
            public List<Student> findALL() {
                TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
                return theQuery.getResultList();
            }



            @Override
            public List<Student> StudentByLastName(String theLastName) {
                TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:TheData", Student.class);
                theQuery.setParameter("TheData",theLastName);

                return theQuery.getResultList();
            }

            @Override
            @Transactional
            public void update(Student theStudent) {
                entityManager.merge(theStudent);

            }

            @Override
            @Transactional
            public void delete(Integer id) {
                Student theStudent = entityManager.find(Student.class,id);
                entityManager.remove(theStudent);
            }

            @Override
            @Transactional
            public int deleteALL() {
                int numofrowdeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

                return numofrowdeleted;
            }
        }
