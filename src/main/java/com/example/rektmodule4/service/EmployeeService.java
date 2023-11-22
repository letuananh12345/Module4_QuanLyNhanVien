package com.example.rektmodule4.service;

import com.example.rektmodule4.model.Employee;
import com.example.rektmodule4.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepo iEmployeeRepo;

    @Override
    public List<Employee> findAll(Sort sort) {
        return (List<Employee>) iEmployeeRepo.findAll(sort);
    }

    @Override
    public Employee findById(long id) {
        return iEmployeeRepo.findById(id).get();
    }

    @Override
    public Employee save(Employee employee) {
        return iEmployeeRepo.save(employee);
    }

    @Override
    public void delete(Employee employee) {
       iEmployeeRepo.delete(employee);
    }



}

