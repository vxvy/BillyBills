package vxvy.billy_bills.data.repository;

import vxvy.billy_bills.domain.model.Job;
import vxvy.billy_bills.domain.model.JobExecution;

public interface JobRepository {
    void saveJob(Job job);
    Job findJobByName(String name);
    JobExecution createJobExecution(Job job);
    void updateJobExecution(JobExecution jobExecution);
}