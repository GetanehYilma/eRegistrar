package edu.mum.cs.cs425.demowebapps.eregistrar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	Optional<Student> findStudentByFirstName(String firstName); // yostoi sonin yumdaa!! Eniig end bichlee.
						
	Optional<Student> findStudentByLastName(String lastName);   // Itellij IDE deer garaad baihiin Eclpise deer alga
	
	Optional<Student> findStudentByStudentId(Integer studentId);

}
