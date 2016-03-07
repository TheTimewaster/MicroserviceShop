package app.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistrationServiceServer implements Runnable
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
		// Tell Boot to look for registration-server.yml
		System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(RegistrationServiceServer.class, args);
	}
}