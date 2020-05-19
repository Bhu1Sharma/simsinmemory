package com.bhuwan.pages;

import com.bhuwan.dom.Student;
import com.bhuwan.services.StudentService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class StudentInformation {

    @Inject
    private StudentService studentService;

    @Property
    private Student student;

    private Long studentId;

    public void onActivate(Long studentId) {
        if (student == null) {
            student = studentService.getById(studentId);
        }
        this.studentId = studentId;
    }

    public Long onPassivate() {
        return studentId;
    }

}
