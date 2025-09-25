package com.tex.api.repository;

import com.tex.api.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Long> {

    public JobEntity save(JobEntity entity);
}

