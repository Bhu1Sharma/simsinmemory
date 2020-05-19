package com.bhuwan.services.impl;

import com.bhuwan.dom.Student;
import com.bhuwan.services.StorageService;
import com.bhuwan.services.StudentService;

import java.util.List;

public class StudentServiceImpl extends StorageService<Student> implements StudentService {

    @Override
    public List<Student> getAll() {
        return getAllForEntity(Student.ENTITY_TYPE);
    }

    @Override
    public Student getById(long studentId) {
        return getAll().stream()
                .filter(student -> student.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> getListByStandard(int standard) {
        return null;
    }

}
