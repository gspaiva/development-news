package com.development.news.developmentnewscrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DevelopmentNewsCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopmentNewsCrawlerApplication.class, args);
	}

}
