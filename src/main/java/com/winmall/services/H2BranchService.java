package com.winmall.services;

import com.winmall.entities.H2Branches;
import com.winmall.repositories.H2BranchRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class H2BranchService {
    @Autowired
    private H2BranchRopository branchRopository;

    public List<H2Branches> getAllBranches(){
        return branchRopository.findAll();
    }

    public H2Branches saveBranches(H2Branches branch){
        return branchRopository.save(branch);
    }

    public Optional<H2Branches> getBranchById(Long id){
        return branchRopository.findById(id);
    }

    public void deleteById(Long branchId){
        branchRopository.deleteById(branchId);
    }

    public Optional<H2Branches> getBranchByName(String name){
        return branchRopository.findByName(name);
    }
}
