package edu.mum.cs.cs425.demowebapps.eregistrar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.mum.cs.cs425.demowebapps.eregistrar.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = {"/student/register"})
	public String showNewStudentRegisterForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/register";
	}
	@PostMapping(value = {"/student/register"})
	public String registerNewStudent(@Valid @ModelAttribute("student") Student student,
	                                     BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            return "student/register";
	        }
	        student = studentService.registerNewStudent(student);
	        System.out.println(student);
	        return "redirect:/student/list";
	    }
	
	@GetMapping(value = {"/student/list"})
	public ModelAndView showStudentsListForm(@RequestParam(defaultValue = "0")int pageNo) {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("students", studentService.getAllStudentPaged(pageNo));
	        modelAndView.addObject("currentPageNo", pageNo); //current page no
	        modelAndView.setViewName("student/list");
	        return modelAndView;
	}
	
	@GetMapping(value = {"/student/edit/{studentId}"})
    public String studentEditForm(@PathVariable Integer studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/list";
    }

    @PostMapping(value = {"/student/edit"})
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping(value = {"/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId, Model model) {
    	System.out.println("deleteStudent");
    	studentService.deleteStudentById(studentId);
        return "redirect:/student/list";
    }
	
	
}
