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
	private StudentRepository repo;

	@Override
	public Iterable<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("firstName", "lastName"));
	}

	@Override
	public Student registerNewStudent(Student newStudent) {
		// TODO Auto-generated method stub
		return repo.save(newStudent);
		
	}

	@Override
	public Page<Student> getAllStudentPaged(int page) {
		// TODO Auto-generated method stub
		return repo.findAll(PageRequest.of(page, 5, Sort.by("firstName","lastName")));
	}

//	@Override
//	public Student findStudentByFirstName(String name) {
//		// TODO Auto-generated method stub
//		return repo.findStudentByFirstName(name);
//	}

	@Override
	public Student saveStudent(@Valid Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

@Override
public Student getStudentById(Integer studentId) {
	// TODO Auto-generated method stub
	return repo.findById(studentId).orElse(null);
}

@Override
public void deleteStudentById(Integer studentId) {
	repo.deleteById(studentId);	
}





}
