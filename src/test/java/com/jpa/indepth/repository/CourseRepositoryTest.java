package com.jpa.indepth.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.indepth.entity.Course;
import com.jpa.indepth.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
            .firstName("Melisa")
            .lastName("O")
            .build();

        Course course = Course.builder()
            .title("Python")
            .credit(6)
            .teacher(teacher)
            .build();

        courseRepository.save(course);
    }

}
