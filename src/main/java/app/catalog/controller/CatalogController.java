package app.catalog.controller;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CatalogController
{	
	private static final String RESOURCE_PATH = "catalog.json";

	protected Logger			logger			= Logger
	        .getLogger(CatalogController.class.getName());

	@Autowired
	public CatalogController()
	{

	}

	@RequestMapping("/catalog/all")
	public String getCatalog()
	{
		ClassLoader cl = this.getClass().getClassLoader();
		
		try
		{
			logger.info("Retrieving data from " + Inet4Address.getLocalHost().getHostName());
		} catch (UnknownHostException e1)
		{
			logger.severe("Hostname could not be resolved!");
		}
		
		JSONObject obj = null;

		try
		{
			File file = new File(cl.getResource(RESOURCE_PATH).toURI());
			
			JSONParser parser = new JSONParser();
			obj = (JSONObject) parser.parse(new FileReader(file));

		} catch (ParseException | IOException | URISyntaxException e)
		{
			logger.severe("Data could not be processed: " + e.getMessage());
		} 
		finally
		{
			
		}

		return obj.toJSONString();
	}
}
