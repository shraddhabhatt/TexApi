/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tex.api.controller.impl;

import com.tex.api.generated.controller.JobApi;
import com.tex.api.generated.model.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shraddhabhatt
 */
@RestController
public class JobApRestController implements JobApi{

    @Override
    public ResponseEntity<Job> editJob(Job job) {
        return JobApi.super.editJob(job); 
    }

    @Override
    public ResponseEntity<Job> postJob(Job job) {
        return JobApi.super.postJob(job); 
    }
    
}
