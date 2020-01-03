package com.southwind.repository;


import com.southwind.entity.Student;

import java.util.Collection;

public interface StudentRepository {
     Collection<Student> findAllStudent();
     Student findById(String studentId);
     void saveOrUpdateStudent(Student student);
     void deleteStudentById(String studentId);
}
