package com.cognizant.stock.service.test.it;


import com.cognizant.stock.model.Student;
import com.cognizant.stock.persistent.DepartmentRepository;
import com.cognizant.stock.persistent.StudentRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.*;
import org.springframework.util.Assert;

import java.sql.SQLException;
import java.util.List;

@Tag("service")
public class TransactionHandlingTesting extends AbstractServiceIntegrationTest {

    private StudentRepository studentRepository;

    private DepartmentRepository departmentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Test
    void Transaction_Required_new () {
        List<Student> student1 = studentRepository.findAll();
        try {
            saveStudent ();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Student> student = studentRepository.findAll();
        Assert.isTrue(student != null, "student is null");
    }

    @Transactional(rollbackFor = {SQLException.class})
    void saveStudent () throws Exception {
        Student student1 = getStudent("Tanisi Pal123", 17, 70, 1);
        studentRepository.save(student1);
        throw new SQLException();
    }

    Student getStudent (String name, Integer age, Integer marks, Integer deptId) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setMarks(marks);
        student.setDepartmentId(deptId);
        return student;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    void saveDepartment () throws Exception {
        throw new Exception();
    }

}
