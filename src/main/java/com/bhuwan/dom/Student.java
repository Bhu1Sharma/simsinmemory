package com.bhuwan.dom;

public class Student implements CommonEntityInterface {

    public static final String ENTITY_TYPE = "STUDENT";

    private long studentId;

    private String name;

    private int age;

    private int standard;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    @Override
    public String getEntityType() {
        return ENTITY_TYPE;
    }

    @Override
    public long getEntityId() {
        return studentId;
    }
}
