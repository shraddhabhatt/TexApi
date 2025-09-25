package com.tex.api.service.impl;

import com.tex.api.entity.JobEntity;
import com.tex.api.generated.model.Job;
import com.tex.api.mapper.JobMapper;
import com.tex.api.repository.JobRepository;
import com.tex.api.service.JobService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @Override
    @Transactional
    public Job editJob(Job job) {
        
        JobEntity existingJob = jobRepository.findById(job.getId())
                .orElseThrow(() -> new IllegalArgumentException("Job not found with id: " + job.getId()));


        // Use mapper to update entity from model
        JobEntity entity = JobMapper.toEntity(job);
        JobEntity updated = jobRepository.save(entity);
        // Convert back to model using mapper
        return JobMapper.toModel(updated);
    }

    @Override
    public List<Job> getAllJobs() {
        List<JobEntity> entities = jobRepository.findAll(Sort.by(Sort.Direction.DESC, "jobId"));
        return entities.stream()
                       .map(JobMapper::toModel)
                       .collect(Collectors.toList());
    }
}
    
    
    


