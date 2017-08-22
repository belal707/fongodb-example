package com.student.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.student.model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String>
{
    public Student findById(Object id);

    public List<Student> findByName(String name);
}
