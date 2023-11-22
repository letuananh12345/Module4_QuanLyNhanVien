package com.example.rektmodule4.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}$", message = "( 5 ký tự bất kỳ,không có ký tự đặc biệt )")
    private String employeeCode;

    @NotEmpty(message = "( Không để trống tên )")
    private String name;

    @Positive(message = "( Nhập số nguyên >0 )")
    private int age;

    @Positive(message = "( Nhập số nguyên >0 )")
    private int salary;

    @ManyToOne
    private Branch branch;

    public Employee() {
    }

    public Employee(long id, String employeeCode, String name, int age, int salary, Branch branch) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}

