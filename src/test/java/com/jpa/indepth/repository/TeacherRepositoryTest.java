package com.jpa.indepth.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.indepth.entity.Course;
import com.jpa.indepth.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher() {

        Course course = Course.builder()
            .title("Geo")
            .credit(3)
            .build();
        Course courseJava = Course.builder()
            .title("Java")
            .credit(6)
            .build();

        Teacher teacher = Teacher.builder()
            .firstName("Amanda")
            .lastName("James")
            .courses(List.of(course, courseJava))
            .build();

        repository.save(teacher);
    }



}
