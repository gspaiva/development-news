package com.development.news.developmentnewsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DevelopmentNewsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopmentNewsServerApplication.class, args);
	}

}
