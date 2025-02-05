package com.wclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients("com.wclient.serviceproxy")
@EnableDiscoveryClient
public class WclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WclientApplication.class, args);
	}

}
