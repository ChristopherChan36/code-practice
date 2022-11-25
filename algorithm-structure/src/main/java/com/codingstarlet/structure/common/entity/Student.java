package com.codingstarlet.structure.common.entity;

public class Student implements Comparable<Student> {

    private String name;

    private Integer age;

    public Student() {

    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return this.age - other.getAge();
    }

    @Override
    public boolean equals(Object student) {
        if (this == student)
            return true;
        if (student == null)
            return false;
        if (this.getClass() != student.getClass())
            return false;
        Student another = (Student) student;
        return this.name.equalsIgnoreCase(another.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
