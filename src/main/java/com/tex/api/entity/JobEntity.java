package com.tex.api.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "Jobs")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "employer_id", nullable = false)
    private Long employerId; // Can be mapped to EmployerEntity if needed

    @Column(name = "user_id", nullable = false)
    private Long userId; // Can be mapped to UserEntity if needed

    @Column(name = "job_title", nullable = false, length = 50)
    private String jobTitle;

    @Column(name = "job_description", nullable = false, length = 4000)
    private String jobDescription;

    @Column(name = "job_responsibilities", nullable = false, length = 4000)
    private String jobResponsibilities;

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_type", length = 10)
    private EmploymentType employmentType; // Full-time, Part-time, Contract

    @Enumerated(EnumType.STRING)
    @Column(name = "work_mode", length = 10)
    private WorkMode workMode; // Remote, On-site, Hybrid

    @Column(name = "location", length = 30)
    private String location;

    @Column(name = "active_status")
    private Boolean activeStatus = true;

    @Column(name = "visa_sponsorship")
    private Boolean visaSponsorship = false;

    @Column(name = "visa_type", length = 5)
    private String visaType;
    
    @Column(name = "salary_min")
    private Double salaryMin;

    @Column(name = "salary_max")
    private Double salaryMax;

    @Column(name = "create_time", columnDefinition = "TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime createTime;

    @Column(name = "update_time", columnDefinition = "TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP")
    private OffsetDateTime updateTime;

    // Getters and Setters

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType;
    }

    public WorkMode getWorkMode() {
        return workMode;
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
    }

    

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Boolean getVisaSponsorship() {
        return visaSponsorship;
    }

    public void setVisaSponsorship(Boolean visaSponsorship) {
        this.visaSponsorship = visaSponsorship;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public Double getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Double getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Double salaryMax) {
        this.salaryMax = salaryMax;
    }
    
    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public OffsetDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(OffsetDateTime updateTime) {
        this.updateTime = updateTime;
    }
    
    public enum EmploymentType {
        FULL_TIME, PART_TIME, CONTRACT
    }

    public enum WorkMode {
        ON_SITE, REMOTE, HYBRID
    }
}
