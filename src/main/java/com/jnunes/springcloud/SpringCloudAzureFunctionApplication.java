package com.jnunes.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.jnunes"})
@EntityScan(basePackages = {"com.jnunes"})
@EnableJpaRepositories(basePackages = {"com.jnunes"})
public class SpringCloudAzureFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAzureFunctionApplication.class, args);
    }

    // mvn clean package
    // mvn azure-functions:run
    // mvn azure-functions:deploy
}
