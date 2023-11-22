package com.example.rektmodule4.service;

import com.example.rektmodule4.model.Branch;
import com.example.rektmodule4.repository.IBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService implements IBranchService {
    @Autowired
    IBranchRepo iBranchRepo;

    @Override
    public List<Branch> findAll() {
        return (List<Branch>) iBranchRepo.findAll();
    }

    @Override
    public Branch findById(long id) {
        return iBranchRepo.findById(id).get();
    }
}
