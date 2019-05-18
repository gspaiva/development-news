package com.development.news.developmentnewsrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DevelopmentNewsRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopmentNewsRepoApplication.class, args);
	}

}
