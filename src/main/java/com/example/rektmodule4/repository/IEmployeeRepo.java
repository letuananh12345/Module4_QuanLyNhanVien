package com.example.rektmodule4.repository;

import com.example.rektmodule4.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee,Long> {
}
