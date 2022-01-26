package com.example.divisapp.controller;

import com.example.divisapp.entity.Course;
import com.example.divisapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {
    @Autowired

    private CourseRepository repository;

    @GetMapping("/courseList")

    public String viewCourses(Model model) {
        model.addAttribute("CourseList1", repository.findAll());
        return "courselist";

    }

    @PostMapping("/addcourse")

    public String addnewCourse(Model model, Course course) {

        model.addAttribute("Course", new Course());
        repository.save(course);
        return "redirect:/courseList";

    }

    @GetMapping("/delete1/{id}")
    public String deleteCourse(@PathVariable("id") Integer id){

        repository.deleteById(id);
        return "redirect:/courseList";

    }


    @GetMapping("/edit1/{id}")
    public String editCourse(@PathVariable("id") Integer id, Model model){

        model.addAttribute("Course1", repository.findById(id) );
        model.addAttribute("courselist", repository.findAll());
        return "editCourse";

    }


}