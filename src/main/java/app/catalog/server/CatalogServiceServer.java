package app.catalog.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import app.catalog.controller.CatalogController;


@EnableAutoConfiguration
@EnableDiscoveryClient
public class CatalogServiceServer
{
	public static void main(String[] args)
	{
		// Will configure using accounts-server.yml
		System.setProperty("spring.config.name", "catalog-server");
		SpringApplication.run(CatalogServiceServer.class, args);
	}
	
	@Bean
	public CatalogController catalogController()
	{
		return new CatalogController();
	}
}
