package com.project4.BGMC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude ={ LiquibaseAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "com.project4.BGMC.repository.wlc")
@EnableAspectJAutoProxy
public class BgmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BgmcApplication.class, args);
	}

}
