package com.beesan.consumingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.beesan.consumingwebservice.wsdl.GetPatientInfoResponse;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(PatientClient quoteClient) {
		return args -> {
			String id = "1";

			if (args.length > 0) {
				id = args[0];
			}
			GetPatientInfoResponse response = quoteClient.getPatient(id);
			System.err.println(response.getPatient().getAge());
		};
	}
}
