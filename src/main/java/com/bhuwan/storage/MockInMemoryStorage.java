package com.bhuwan.storage;

import com.bhuwan.dom.Student;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockInMemoryStorage {

    private static MockInMemoryStorage storageInstance;

    private final Map<String, List<Object>> entityStorage;

    private MockInMemoryStorage() {
        entityStorage = new HashMap<>();
    }

    public static MockInMemoryStorage getInstance() {
        if (storageInstance == null) {
            storageInstance = new MockInMemoryStorage();
        }
        storageInstance.getEntityStorage().put(Student.ENTITY_TYPE, getMockStudents());
        return storageInstance;
    }

    private static List<Object> getMockStudents() {
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Bhuwan Sharma");
        student.setAge(24);
        student.setStandard(19);
        return Collections.singletonList(student);
    }

    public Map<String, List<Object>>  getEntityStorage() {
        return entityStorage;
    }

}
