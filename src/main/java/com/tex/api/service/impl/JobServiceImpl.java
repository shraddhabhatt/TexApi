package com.tex.api.service.impl;

import com.tex.api.entity.JobEntity;
import com.tex.api.generated.model.Job;
import com.tex.api.mapper.JobMapper;
import com.tex.api.repository.JobRepository;
import com.tex.api.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private final JobRepository jobRepository;
   
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job postJob(Job job) {
        JobEntity entity = JobMapper.toEntity(job);
        jobRepository.save(entity);
        Job model = JobMapper.toModel(entity);
        return model;
    }
    
}

