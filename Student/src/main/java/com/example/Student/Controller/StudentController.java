package com.example.Student.Controller;

import com.example.Student.Entity.Student;
import com.example.Student.Error.UserNotFound;
import com.example.Student.Repository.StudentRepo;
import com.example.Student.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class StudentController
{
    @Autowired
    private StudentsService studentsService;

    @Autowired
    private StudentRepo studentRepo;


    @PostMapping("/SaveStudents")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        try {
            studentsService.saveStudent(student);
            return ResponseEntity.ok("Student saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the student: " + e.getMessage());
        }
    }

    @GetMapping("/GetStuByName/{name}")
    public Optional<Student> getStudent(@PathVariable String name) throws UserNotFound {
        return studentsService.getStudent(name);
    }

    @GetMapping("/GetStuById/{id}")
    public List<Student> getStudentById(@PathVariable Long id)
    {
        return studentRepo.findAllById(id);
    }

    @PutMapping("/UpdateSyudent/{id}")
    public Student updateStu(@PathVariable Long id,@RequestBody Student student)
    {
        Student c=studentRepo.findById(id).orElse(null);

        if (Objects.nonNull(student.getName()) && !student.getName().trim().isEmpty())
        {
            c.setName(student.getName());
        } else {
            c.setName(null);
        }

        if (Objects.nonNull(student.getDob()))
        {
            c.setDob(student.getDob());
        } else {
            c.setDob(null);
        }

        if (Objects.nonNull(student.getAddress()) && !student.getAddress().trim().isEmpty())
        {
            c.setAddress(student.getAddress());
        } else {
            c.setAddress(null);
        }

        if (Objects.nonNull(student.getStdClass()) && !student.getStdClass().trim().isEmpty())
        {
            c.setStdClass(student.getStdClass());
        } else {
            c.setStdClass(null);
        }

        if (Objects.nonNull(student.getClassTeacher()) && !student.getClassTeacher().trim().isEmpty())
        {
            c.setClassTeacher(student.getClassTeacher());
        } else {
            c.setClassTeacher(null);
        }

        return studentRepo.save(c);

    }

    @DeleteMapping("/DeletedStuById/{id}")
    public ResponseEntity<String> deletedStuById(@PathVariable Long id)
    {
        studentRepo.deleteById(id);
        return ResponseEntity.ok("Deleted Data Successfully");
    }


}
