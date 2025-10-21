package vxvy.billy_bills.core.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BillingJobConfiguration {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public BillingJobConfiguration(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager
    ) {
        System.out.println("BillingJobConfiguration created!");
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public Job billingJob() {
        return new JobBuilder("billingJob", jobRepository)
                .start(billingStep())
                .build();
    }

    @Bean
    public Step billingStep() {
        return new StepBuilder("billingStep", jobRepository)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("processing billing information");
                    return RepeatStatus.FINISHED;
                }, transactionManager)
                .build();
    }
}
