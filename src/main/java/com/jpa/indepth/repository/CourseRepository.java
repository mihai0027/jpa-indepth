package com.jpa.indepth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.indepth.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
