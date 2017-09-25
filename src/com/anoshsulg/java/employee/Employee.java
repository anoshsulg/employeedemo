package com.anoshsulg.java.employee;


import java.util.Arrays;
import java.util.List;

public class Employee {
    private String name;
    private String state;
    private int age;
    private List<String> assignments;

    public Employee(String name, String state, int age, String... assignments) {
        this.name = name;
        this.state = state;
        this.age = age;

        this.assignments = Arrays.asList(assignments);


        System.out.println("creating employee");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<String> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                ", assignments=" + assignments +
                '}';
    }
}
