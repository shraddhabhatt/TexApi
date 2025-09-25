/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tex.api.controller.impl;

import com.tex.api.generated.controller.JobApi;
import com.tex.api.generated.model.Job;
import com.tex.api.service.JobService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shraddhabhatt
 */
@RestController
@RequestMapping("/job")
public class JobController implements JobApi{

    @Autowired
    private final JobService jobService;

    public JobController (JobService jobService) {
        this.jobService = jobService;
    }
    
    @Override
    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Job> editJob(@Valid @RequestBody Job job) {
        Job updatedJob = jobService.editJob(job);
        return ResponseEntity.ok(updatedJob);
    }

    @Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Job> postJob(@Valid @RequestBody Job job) {
        Job savedJob = jobService.postJob(job);
        return ResponseEntity.ok(savedJob);
    }
    
    @Override
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        if (jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jobs);
    }
    
}
