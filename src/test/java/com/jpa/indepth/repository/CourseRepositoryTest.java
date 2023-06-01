package com.jpa.indepth.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination() {
        // first page with first 3 records
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        // second page with 2 records
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);

    }

    @Test
    public void findAllWithSorting() {

        // implement here sorting based on course title
        //Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        //Pageable sortByCreditDesc = PageRequest.of(0, 4, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending()
            .and(Sort.by("credit")));

            List<Course> courses = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

        System.out.println("courses sorted = " + courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("a", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

}
