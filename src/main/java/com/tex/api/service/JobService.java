package com.tex.api.service;

import com.tex.api.generated.model.Job;
import java.util.List;

public interface JobService {
    
    Job postJob(Job job);
    
    Job editJob(Job job);
    
    List<Job> getAllJobs();
}
