package com.jpa.indepth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.indepth.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}
