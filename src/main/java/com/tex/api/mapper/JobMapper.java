package com.tex.api.mapper;

import com.tex.api.entity.JobEntity;
import com.tex.api.generated.model.Job;

import java.time.OffsetDateTime;

public class JobMapper {

    // Convert Swagger-generated model to JPA entity
    public static JobEntity toEntity(Job model) {
        if (model == null) return null;

        JobEntity entity = new JobEntity();

        // Only map fields present in the model
        entity.setJobId(model.getId());
        entity.setEmployerId(model.getEmployerId());
        entity.setUserId(model.getUserId());
        entity.setJobTitle(model.getJobTitle());
        entity.setJobDescription(model.getJobDescription());
        entity.setJobResponsibilities(model.getJobResponsibilities());
        entity.setLocation(model.getLocation());
        entity.setActiveStatus(model.getActiveStatus() != null ? model.getActiveStatus() : true);
        entity.setVisaSponsorship(model.getVisaSponsorship() != null ? model.getVisaSponsorship() : false);
        entity.setVisaType(model.getVisaType());
        entity.setCreateTime(model.getCreateTime() != null ? model.getCreateTime() : OffsetDateTime.now());
        entity.setUpdateTime(OffsetDateTime.now());
        
        // Map Swagger ENUM to Entity ENUM
        if (model.getEmploymentType() != null) {
            entity.setEmploymentType(
                JobEntity.EmploymentType.valueOf(model.getEmploymentType().name())
            );
        }

        if (model.getWorkMode() != null) {
            entity.setWorkMode(
                JobEntity.WorkMode.valueOf(model.getWorkMode().name())
            );
        }


        return entity;
    }

    // Convert JPA entity to Swagger-generated model
    public static Job toModel(JobEntity entity) {
        if (entity == null) return null;

        Job model = new Job();

        model.setId(entity.getJobId());
        model.setEmployerId(entity.getEmployerId());
        model.setUserId(entity.getUserId());
        model.setJobTitle(entity.getJobTitle());
        model.setJobDescription(entity.getJobDescription());
        model.setJobResponsibilities(entity.getJobResponsibilities());
        model.setLocation(entity.getLocation());
        model.setActiveStatus(entity.getActiveStatus());
        model.setVisaSponsorship(entity.getVisaSponsorship());
        model.setVisaType(entity.getVisaType());
        model.setCreateTime(entity.getCreateTime());
        model.setUpdateTime(entity.getUpdateTime());
        
        // Map Entity ENUM to Swagger ENUM
        if (entity.getEmploymentType() != null) {
            model.setEmploymentType(
                Job.EmploymentTypeEnum.valueOf(entity.getEmploymentType().name())
            );
        }
        
        if (entity.getWorkMode() != null) {
            model.setWorkMode(
                Job.WorkModeEnum.valueOf(entity.getWorkMode().name())
            );
        }

        return model;
    }
}

