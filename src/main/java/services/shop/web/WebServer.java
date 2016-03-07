package services.shop.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters=false)
public class WebServer implements Runnable
{
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
}

