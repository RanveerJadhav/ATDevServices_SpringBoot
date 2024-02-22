package com.example.Student.Service;

import com.example.Student.Entity.Student;
import com.example.Student.Error.UserNotFound;

import java.util.Optional;

public interface StudentsService
{


    void saveStudent(Student student);

    Optional<Student> getStudent(String name) throws UserNotFound;
}
