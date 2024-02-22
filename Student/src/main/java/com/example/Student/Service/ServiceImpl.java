package com.example.Student.Service;

import com.example.Student.Entity.Student;
import com.example.Student.Error.UserNotFound;
import com.example.Student.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl implements StudentsService
{

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public void saveStudent(Student student)
    {

        studentRepo.save(student);

    }

    @Override
    public Optional<Student> getStudent(String name) throws UserNotFound
    {
        Optional<Student> x=studentRepo.findAllByName(name);
        if (x.isPresent())
        {
              return x;
        }
       throw new UserNotFound("User Not Found!");
    }
}
