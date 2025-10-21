package vxvy.billy_bills.domain.repositoryimpl;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.stereotype.Repository;
import vxvy.billy_bills.domain.model.Job;
import vxvy.billy_bills.domain.model.JobExecution;

@Repository
public class SpringBatchJobRepositoryAdapter implements vxvy.billy_bills.data.repository.JobRepository {

    private final JobRepository springJobRepository;

    public SpringBatchJobRepositoryAdapter(JobRepository springJobRepository) {
        this.springJobRepository = springJobRepository;
    }

    @Override
    public void saveJob(Job job) {
        // Implementation would map domain Job to Spring Batch Job
    }

    @Override
    public Job findJobByName(String name) {
        // Implementation would map Spring Batch Job to domain Job
        return null;
    }

    @Override
    public JobExecution createJobExecution(Job job) {
        // Implementation would create Spring Batch JobExecution and map to domain
        return null;
    }

    @Override
    public void updateJobExecution(JobExecution jobExecution) {
        // Implementation would map domain JobExecution to Spring Batch and update
    }
}