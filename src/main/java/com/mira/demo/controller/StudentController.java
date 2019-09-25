package com.mira.demo.controller;

import com.mira.demo.entities.Student;
import com.mira.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})

public class StudentController {

    @Autowired
    private StudentService s;

    @GetMapping(value = "/")
    public String main(){
        return "index";
    }
    @GetMapping("/estudiantes")
    public String main(Model model){
        List<Student> students = s.findAll();
        model.addAttribute("students", students);
        return "index";
    }
    @GetMapping("/editEstudents/{id}")
    public ModelAndView editStudent(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        Student students = s.findOne(id);
        mav.addObject("students", students);

        return mav;
    }
    @GetMapping("/createStudent")
    public String createStudent(Model model) {

        Student students = new Student();
        model.addAttribute("students", students);

        return "edit";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("students") Student students){
        s.save(students);

        return "redirect:/estudiantes";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id){
        s.delete(id);
        return "redirect:/estudiantes";
    }

//    public List<Student> list(){
//
//        return this.s.findAll();
//
//    }

    /*NO HACER CASO A ESTO POR AHORA

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/insert", headers = "Accept=application/json")
    public Student insert(@RequestBody Student student){
        //System.out.println(student.getId_student());
        s.save(student);
        return student;
    }

    @PostMapping(path="/update")
    public Student update(@RequestBody Student student){



        return student;
    }*/

}
