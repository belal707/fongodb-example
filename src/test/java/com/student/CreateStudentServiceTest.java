package com.student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.student.controller.StudentController;
import com.student.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateStudentServiceTest
{
    
    @Autowired
    StudentController serviceController;
    
    Student std ;
    
    @Before
    public void setUp()
    {
        std = new Student();
        
        std.setName("belal");
        std.setRollNo("10");
    }
    @Test
    public void createTest()
    {
        ResponseEntity<?> result = null;
        try
        {
            result = serviceController.createStudent(std);
            Assert.assertEquals(result.getStatusCode().toString(), "201");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
