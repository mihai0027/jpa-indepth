package com.jpa.indepth.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.indepth.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    @Query(
        value = "select * from student_table s where s.email_address = ?1",
        nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);
    
}


