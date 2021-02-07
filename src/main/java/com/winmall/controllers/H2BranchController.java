package com.winmall.controllers;

import com.winmall.entities.H2Branches;
import com.winmall.services.H2BranchService;
import com.winmall.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class H2BranchController {
    @Autowired
    private H2BranchService  branchService;

    @GetMapping("/branches")
    public List<H2Branches> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/branches/{name}")
    public H2Branches getBranchByName(@PathVariable(value = "name") String branchName) throws ResourceNotFoundException {
        H2Branches branches = branchService.getBranchByName(branchName)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found for this name : " + branchName));
        return branches;
    }

    @PostMapping("/branches")
    public H2Branches createBranch(@RequestBody H2Branches branch) throws ResourceNotFoundException {
        H2Branches branches = branchService.getBranchByName(branch.getBname())
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found for this name : " + branch.getBname()));

        if (branch.getBname().equals(branches.getBname())){
            return null;
        }

        return branchService.saveBranches(branch);
    }
    @PutMapping("/branches/{id}")
    public ResponseEntity<H2Branches> updateBranch(@PathVariable(value = "id") Long branchId, @RequestBody H2Branches branch)
            throws ResourceNotFoundException{

        H2Branches branches = branchService.getBranchById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found for this id : " + branchId));
        branches.setBname(branch.getBname());
        branches.setBlocation(branch.getBlocation());
        branches.setBsize(branch.getBsize());
        branches.setBtel(branch.getBtel());
        final H2Branches updatedBranch = branchService.saveBranches(branches);
        return ResponseEntity.ok(updatedBranch);
    }

    @DeleteMapping("/branches/{id}")
    public Map< String, Boolean > deleteBranch(@PathVariable(value = "id") Long branchId)
            throws ResourceNotFoundException {
        H2Branches branch = branchService.getBranchById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + branchId));
        Boolean deleteCheck = false;
        try {
            branchService.deleteById(branchId);
            deleteCheck = true;
        }catch (Exception e){
//            e.printStackTrace();
            deleteCheck = false;
        }

        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", deleteCheck);
        return response;
    }
}
