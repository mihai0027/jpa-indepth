package com.jpa.indepth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.indepth.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}


