package com.example.rektmodule4.service;

import com.example.rektmodule4.model.Branch;

import java.util.List;

public interface IBranchService  {
    List<Branch> findAll();
    Branch findById(long id);
}
