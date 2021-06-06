package com.example.demo.service;

import com.example.demo.model.BranchEntity;
import com.example.demo.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    public BranchEntity getBranch(Integer id){
        return branchRepository.findById(id).get();
    }
}
