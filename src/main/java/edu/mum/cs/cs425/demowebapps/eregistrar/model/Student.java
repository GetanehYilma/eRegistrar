package edu.mum.cs.cs425.demowebapps.eregistrar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
		
		@Id@GeneratedValue
		private Integer studentId; // : (should be primary key field)
		
		@NotBlank(message = "Please provide number")
		private String studentNumber; //: e.g. 000-61-0001 (required)
		
		@NotBlank(message = "Please provide first name")
		private String firstName; //: e.g. Anna (required)
		
		private String middleName;	//: (optional)
		
		@NotBlank(message = "Please provide last name")
		private String lastName; //: e.g. Smith (required)
		
		private	String cgpa; //: e.g. 3.78 (optional)
		
		@NotBlank(message = "Please provide date")
		@DateTimeFormat(pattern = "MM/dd/yyyy")
		private String enrollmentDate; //: e.g. 2019-5-12 (required)
		
		
		private Boolean isInternational; //: (values: "Yes", "No") (required) - Hint: Implement/present this data in a drop-down list

		public Student() {

		}

		public Student(@NotBlank(message = "* Student number is required!") String studentNumber,
				@NotBlank(message = "* First name is required!") String firstName, String middleName,
				@NotBlank(message = "* Last name is required!") String lastName, String cgpa,
				@NotBlank String enrollmentDate,
				@NotBlank(message = "* This field is required!") Boolean isInternational) {
			this.studentNumber = studentNumber;
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.cgpa = cgpa;
			this.enrollmentDate = enrollmentDate;
			this.isInternational = isInternational;
		}



		public Integer getStudentId() {
			return studentId;
		}

		public void setStudentId(Integer studentId) {
			this.studentId = studentId;
		}

		public String getStudentNumber() {
			return studentNumber;
		}

		public void setStudentNumber(String studentNumber) {
			this.studentNumber = studentNumber;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getCgpa() {
			return cgpa;
		}

		public void setCgpa(String cgpa) {
			this.cgpa = cgpa;
		}

		public String getEnrollmentDate() {
			return enrollmentDate;
		}

		public void setEnrollmentDate(String enrollmentDate) {
			this.enrollmentDate = enrollmentDate;
		}

		public Boolean getIsInternational() {
			return isInternational;
		}

		public void setIsInternational(Boolean isInternational) {
			this.isInternational = isInternational;
		}

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
					+ ", middleName=" + middleName + ", lastName=" + lastName + ", cgpa=" + cgpa + ", enrollmentDate="
					+ enrollmentDate + ", isInternational=" + isInternational + "]";
		}

		
}
