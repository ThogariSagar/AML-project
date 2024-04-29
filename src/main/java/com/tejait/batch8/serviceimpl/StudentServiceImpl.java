package com.tejait.batch8.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejait.batch8.model.Student;
import com.tejait.batch8.repository.StudentRepository;
import com.tejait.batch8.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{
	@Autowired
	StudentRepository stdRepository;

	@Override
	public Student saveStudent(Student student) {
     String fname=student.getFname();
     String lname=student.getLname();
     String fullname=fname.concat(" "+lname);
     student.setFullname(fullname);
    		Student stdt=stdRepository.save(student);
		return stdt;
	}

	@Override
	public List<Student> getTheListStudent() {
		
		return stdRepository.findAll();
	}

	@Override
	public List<Student> getStudentList() {
		
		return  stdRepository.findAll();
	}

}
