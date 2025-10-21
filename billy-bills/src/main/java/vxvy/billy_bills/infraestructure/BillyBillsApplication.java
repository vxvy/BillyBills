package vxvy.billy_bills.infraestructure;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "vxvy.billy_bills")
@EnableBatchProcessing
public class BillyBillsApplication {

	public static void main(String[] args) {

        SpringApplication.run(BillyBillsApplication.class, args);
	}

}
