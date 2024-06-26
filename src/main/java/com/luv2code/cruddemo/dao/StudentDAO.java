package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student thestudent);


    //create method for to get student get by id
    Student findById(Integer id);

    List<Student> findALL();

     List<Student> StudentByLastName(String theLastName);

     void update(Student theStudent);

     void delete(Integer id);

     int deleteALL();


}
