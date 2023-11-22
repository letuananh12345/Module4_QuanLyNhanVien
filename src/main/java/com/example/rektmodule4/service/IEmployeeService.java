package com.example.rektmodule4.service;

import com.example.rektmodule4.model.Employee;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll(Sort sort);

    Employee findById(long id);

    Employee save(Employee employee);

    void delete(Employee employee);

}
