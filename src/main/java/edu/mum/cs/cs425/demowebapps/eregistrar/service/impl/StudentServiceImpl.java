package edu.mum.cs.cs425.demowebapps.eregistrar.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.repository.StudentRepository;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Iterable<Student> getAllStudents() {
		return studentRepo.findAll(Sort.by("firstName", "lastName"));
	}

	@Override
	public Student registerNewStudent(Student newStudent) {
		return studentRepo.save(newStudent);
		
	}

	@Override
	public Page<Student> getAllStudentPaged(int page) {
		return studentRepo.findAll(PageRequest.of(page, 5, Sort.by("firstName","lastName")));
	}

	@Override
	public Student saveStudent(@Valid Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Integer studentId) {
	return studentRepo.findById(studentId).orElse(null);
}

	@Override
	public void deleteStudentById(Integer studentId) {
		studentRepo.deleteById(studentId);	
}





}
