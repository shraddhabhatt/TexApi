/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tex.api.controller.impl;

import com.tex.api.generated.controller.JobApi;
import com.tex.api.generated.model.Job;
import com.tex.api.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shraddhabhatt
 */
@RestController
public class JobController implements JobApi{

    @Autowired
    private final JobService jobService;

    public JobController (JobService jobService) {
        this.jobService = jobService;
    }
    
    @Override
    public ResponseEntity<Job> editJob(Job job) {
        return JobApi.super.editJob(job); 
    }

    @Override
    public ResponseEntity<Job> postJob(@RequestBody Job job) {
        Job savedJob = jobService.postJob(job);
        return ResponseEntity.ok(savedJob);
    }
    
}
