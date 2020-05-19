package com.bhuwan.pages;

import com.bhuwan.dom.Student;
import com.bhuwan.services.StudentService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

public class Index {

    @Inject
    private StudentService studentService;

    @Property
    private Student student;

    public String getMessage() {
        return "Hello World! ";
    }

    public List<Student> getStudents() {
        return studentService.getAll();
    }

}
