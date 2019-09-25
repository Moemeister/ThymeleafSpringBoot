package com.mira.demo.service;

import com.mira.demo.entities.Student;
import com.mira.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository s;

    @Override
    public List<Student> findAll() {
        return s.findAll();
    }

    @Override
    public Student findOne(Integer id) {
        return s.getOne(id);
    }

    @Override
    public void delete(Integer id) {
         s.deleteById(id);
    }

    @Override
    public Student save(Student student) {
        return s.save(student);
    }

}
