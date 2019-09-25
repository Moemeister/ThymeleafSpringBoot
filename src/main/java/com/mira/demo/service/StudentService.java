package com.mira.demo.service;

import com.mira.demo.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    Student save(Student s);
    Student findOne(Integer id);
    void delete(Integer id);


}
