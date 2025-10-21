package vxvy.billy_bills.infraestructure.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class JobLauncherService implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job billingJob;

    public JobLauncherService(JobLauncher jobLauncher, Job billingJob) {
        this.jobLauncher = jobLauncher;
        this.billingJob = billingJob;
    }

    @Override
    public void run(String... args) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(billingJob, jobParameters);
        System.out.println("Job Status: " + jobExecution.getStatus());
    }
}