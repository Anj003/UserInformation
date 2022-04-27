package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class config {
  
	@Bean
	@LoadBalanced
    public RestTemplate getRestTemplate() {
		RestTemplate r=new RestTemplate();
		return r;
	}
	//private RestTemplate r;
	
	//in another controller write
	// String HotelManagement=r.getForObject("http://localhost:8080/hotelmanagement",String.class);
	//return HotelManagement;
}
