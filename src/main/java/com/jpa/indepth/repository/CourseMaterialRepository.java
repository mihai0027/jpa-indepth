package com.jpa.indepth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.indepth.entity.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
    
}
