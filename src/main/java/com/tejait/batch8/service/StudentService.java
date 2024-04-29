package com.tejait.batch8.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tejait.batch8.model.Student;

@Service
public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getTheListStudent();

	List<Student> getStudentList();

	



}
