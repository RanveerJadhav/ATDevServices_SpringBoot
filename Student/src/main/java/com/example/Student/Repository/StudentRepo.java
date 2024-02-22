package com.example.Student.Repository;

import com.example.Student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long>
{
    Optional<Student> findAllByName(String name);

    List<Student> findAllById(Long id);
}
