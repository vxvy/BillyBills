package vxvy.billy_bills.domain.model;

import java.time.LocalDateTime;

public class JobExecution {
    private Long id;
    private Job job;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public JobExecution(Job job) {
        this.job = job;
        this.startTime = LocalDateTime.now();
        this.status = "STARTED";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}