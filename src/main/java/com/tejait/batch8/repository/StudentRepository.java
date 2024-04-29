package com.tejait.batch8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch8.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
