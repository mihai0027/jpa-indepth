package com.jpa.indepth.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.indepth.entity.Guardian;
import com.jpa.indepth.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
            .emailId("john@google.com")
            .firstName("John")
            .lastName("Smith")
            //.guardianName("Alex")
            //.guardianEmail("alex@gmail.com")
            //.guardianMobile("1234567")
            .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentwithGuardion() {

        Guardian guardian = Guardian.builder()
            .email("guard@gmail.com")
            .name("G Ard")
            .mobile("43212452")
            .build();


        Student student = Student.builder()
            .emailId("mike@outlook.com")
            .firstName("mike")
            .lastName("bro")
            .guardian(guardian)
            .build();

        studentRepository.save(student);
        
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
}
