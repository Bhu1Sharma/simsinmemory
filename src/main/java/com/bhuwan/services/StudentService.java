package com.bhuwan.services;

import com.bhuwan.dom.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student getById(long studentId);

    List<Student> getListByStandard(int standard);

}
