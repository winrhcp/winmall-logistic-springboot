package com.winmall.controllers;

import com.winmall.entities.FBBranches;
import com.winmall.services.FBBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

//for cloud firestore
@RestController
public class FBBranchController {
    @Autowired
    FBBranchService FBBranchService;

    @GetMapping("/getAllBranches")
    public FBBranches getAllBranches() throws InterruptedException, ExecutionException{
        return FBBranchService.getAllBranches();
    }

    @GetMapping("/getBranchDetails")
    public FBBranches getBranch(@RequestParam String name ) throws InterruptedException, ExecutionException {
        return FBBranchService.getBranchDetails(name);
    }

    @PostMapping("/createBranch")
    public String createBranch(@RequestBody FBBranches branch ) throws InterruptedException, ExecutionException {
        return FBBranchService.saveBranchDetails(branch);
    }

    @PutMapping("/updateBranch")
    public String updateBranch(@RequestBody FBBranches branch ) throws InterruptedException, ExecutionException {
        return FBBranchService.updateBranchDetails(branch);
    }

    @DeleteMapping("/deleteBranch")
    public String deleteBranch(@RequestParam String name){
        return FBBranchService.deleteBranch(name);
    }

}
