package com.winmall.controller;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.winmall.entity.Branches;
import com.winmall.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class BranchController {
    @Autowired
    BranchService branchService;

    @GetMapping("/getAllBranches")
    public Branches getAllBranches() throws InterruptedException, ExecutionException{
        return branchService.getAllBranches();
    }

    @GetMapping("/getBranchDetails")
    public Branches getBranch(@RequestParam String name ) throws InterruptedException, ExecutionException {
        return branchService.getBranchDetails(name);
    }

    @PostMapping("/createBranch")
    public String createBranch(@RequestBody Branches branch ) throws InterruptedException, ExecutionException {
        return branchService.saveBranchDetails(branch);
    }

    @PutMapping("/updateBranch")
    public String updateBranch(@RequestBody Branches branch ) throws InterruptedException, ExecutionException {
        return branchService.updateBranchDetails(branch);
    }

    @DeleteMapping("/deleteBranch")
    public String deleteBranch(@RequestParam String name){
        return branchService.deleteBranch(name);
    }

}
