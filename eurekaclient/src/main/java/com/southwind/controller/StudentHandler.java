package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentHandler {

    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepository.findAllStudent();
    }

    @GetMapping("/findById/{studentId}")
    public Student findById(@PathVariable("studentId")String studentId){
        return studentRepository.findById(studentId);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.saveOrUpdateStudent(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentRepository.saveOrUpdateStudent(student);
    }

    @DeleteMapping("deleteById/{studentId}")
    public void deleteById(@PathVariable("studentId")String studentId){
        studentRepository.deleteStudentById(studentId);
    }

    @GetMapping("/index")
    public String index(){
        return  "当前端口"+port;
    }





}
