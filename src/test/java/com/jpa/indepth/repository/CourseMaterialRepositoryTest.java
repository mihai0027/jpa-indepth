package com.jpa.indepth.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.indepth.entity.Course;
import com.jpa.indepth.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial() {

        Course course = Course.builder()
            .title(".Net")
            .credit(6)
            .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
            .url("www.bing.com")
            .course(course)
            .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println(courseMaterials);
    }

    




}
