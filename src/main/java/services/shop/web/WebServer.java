package services.shop.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters=false)
public class WebServer
{
	public static void main(String[] args)
    {
		System.getProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
    }

//	@Bean
//	public Weba
}
