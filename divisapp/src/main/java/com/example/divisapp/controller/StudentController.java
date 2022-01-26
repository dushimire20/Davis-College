package com.example.divisapp.controller;

import com.example.divisapp.entity.Student;
import com.example.divisapp.repository.CourseRepository;
import com.example.divisapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class StudentController {

    @Autowired

    private StudentRepository repository;
    private CourseRepository courseRepository;

    @GetMapping("/StudentList")

    public String viewStudent(Model model, Student student){
        model.addAttribute("StudentList1", repository.findAll() );

        return "StudentList";

    }

    @PostMapping("/addstudent")

    public String addnewStudent(Model model, Student student){

        model.addAttribute("Student", new Student());
        repository.save(student);
        return "redirect:/StudentList";


    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/StudentList" ;

    }



    @GetMapping("/edit/{id}")

    public String editProduct(@PathVariable("id") Integer id, Model model){

        model.addAttribute("student1", repository.findById(id).get());
        model.addAttribute("StudentList" ,repository.findAll());

        return "editStudent";


    }

}
