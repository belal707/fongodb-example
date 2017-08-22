package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService
{

    public Student createStudent(Student student) throws Exception;

    public Student updateStudent(Student student) throws Exception;

    public void deleteStudent(String id) throws Exception;

    public List<Student> listStudent() throws Exception;

    public Student getById(String id) throws Exception;

    public List<Student> searchStudent(String name) throws Exception;
}
