package com.ad.compaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.ad.campaign"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class AdCampaignRestApiApp {
	public static void main(String[] args) {
		SpringApplication.run(AdCampaignRestApiApp.class, args);
	}
}
