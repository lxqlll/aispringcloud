package com.southwind.repository.impl;


import com.southwind.entity.Student;
import com.southwind.repository.StudentRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private  static Map<String,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put("stu001",new Student("stu001","张三",'男'));
        studentMap.put("stu002",new Student("stu002","李四",'女'));
        studentMap.put("stu003",new Student("stu003","王五",'男'));
    }


    @Override
    public Collection<Student> findAllStudent() {
        return studentMap.values();
    }

    @Override
    public Student findById(String studentId) {
        return studentMap.get(studentId);
    }

    @Override
    public void saveOrUpdateStudent(Student student) {
        studentMap.put(student.getStudentId(),student);
    }

    @Override
    public void deleteStudentById(String studentId) {
        studentMap.remove(studentId);
    }
}
