package com.southwind.controller;



import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collection;



@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/query")
    @ResponseBody
    public String query(){
        return "123";
    }

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:7778/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:7778/student/findAll",Collection.class);
    }

    @GetMapping("/findAllById/{studentId}")
    public Student findAllById(@PathVariable("studentId")String studentId){
        return restTemplate.getForEntity("http://localhost:7778/student/findAllById/{studentId}",Student.class,studentId).getBody();
    }

    @GetMapping("/findAllById2/{studentId}")
    public Student findAllById2(@PathVariable("studentId")String studentId){
        return restTemplate.getForObject("http://localhost:7778/student/findAllById/{studentId}",Student.class,studentId);
    }

    @PostMapping("/save")
    public void  save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:7778/student/save",student,null).getBody();
    }

    @PostMapping("/save2")
    public void  save2(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:7778/student/save",student,null);
    }

    @PutMapping("/update")
    public void  update(@RequestBody Student student){
        restTemplate.put("http://localhost:7778/student/update",student);
    }

    @DeleteMapping("/deleteById/{studentId}")
    public void  delete(@PathVariable("studentId")String studentId){
        restTemplate.delete("http://localhost:7778/student//deleteById/{studentId}",studentId);
    }
}

