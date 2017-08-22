package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

/**
 * 
 * @author Belal
 *
 */

@RestController
@RequestMapping("/api/student")
public class StudentController
{

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody Student student)
    {
        Student studentResponse = null;
        try
        {
            studentResponse = studentService.createStudent(student);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Student>(studentResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@RequestBody Student student)
    {
        Student studentResponse = null;
        try
        {
            studentResponse = studentService.updateStudent(student);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Student>(studentResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> listStudent()
    {
        List<Student> studentResponse = null;
        try
        {
            studentResponse = studentService.listStudent();
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Student>>(studentResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getByStudentId(@PathVariable("id") String id)
    {
        Student studentResponse = null;
        try
        {
            studentResponse = studentService.getById(id);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Student>(studentResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent(@PathVariable("id") String id)
    {
        try
        {
            studentService.deleteStudent(id);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> searchStudent(@PathVariable("name") String name)
    {
        try
        {
            studentService.searchStudent(name);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
}
