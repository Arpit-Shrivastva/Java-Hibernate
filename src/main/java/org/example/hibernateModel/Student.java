package org.example.hibernateModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="course")
    private String course;
    @Column(name="completion")
    private int completion;
    @Column(name="age")
    private int age;

    public Student() {
    }

    public Student(int id, String name, String course, int completion, int age) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.completion = completion;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getCompletion() {
        return completion;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
