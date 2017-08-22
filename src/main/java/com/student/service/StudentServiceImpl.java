package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student createStudent(Student student) throws Exception
    {

        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student) throws Exception
    {
        if (student.getId() != null)
        {
            return studentRepo.save(student);
        }
        else
        {
            throw new Exception("Id not found...");
        }

    }

    @Override
    public void deleteStudent(String id) throws Exception
    {
        if (id != null)
        {
            Student st = studentRepo.findById(id);
            if(st!=null)
            {
                studentRepo.delete(st.getId());
            }
            else
            {
                throw new Exception("Not found");
            }
        }
        else
        {
            throw new Exception("Id not found...");
        }
    }

    @Override
    public List<Student> listStudent() throws Exception
    {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(String id) throws Exception
    {
        return studentRepo.findById(id);
    }

    @Override
    public List<Student> searchStudent(String name) throws Exception
    {
        return studentRepo.findByName(name);
    }

}
