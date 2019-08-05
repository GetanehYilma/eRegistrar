package edu.mum.cs.cs425.demowebapps.eregistrar.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;


public interface StudentService {
	public abstract Iterable<Student> getAllStudents();
	public abstract Page<Student> getAllStudentPaged(int page);
	public abstract Student registerNewStudent(Student newStudent);
	
	public abstract Student getStudentById(Integer studentId);	
	public abstract Student saveStudent(@Valid Student student);
	public abstract void deleteStudentById(Integer studentId);
	
}
