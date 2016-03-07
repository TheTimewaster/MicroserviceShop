package app.web.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import app.web.controller.WebCatalogController;
import app.web.services.WebCatalogService;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters=false)
public class WebServer implements Runnable
{
	public static final String CATALOG_SERVICE_URL = "http://CATALOG-SERVICE";
	
	public void run()
	{
		launch(new String[]{""});
	}
	
	public static void main(String[] args)
    {
		launch(args);	
    }
	
	private static void launch(String[] args)
	{
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}
	
	@Bean
	public WebCatalogService catalogService()
	{
		return new WebCatalogService(CATALOG_SERVICE_URL);
	}
	
	@Bean
	public WebCatalogController catalogController()
	{
		return new WebCatalogController(catalogService());
	}

}

