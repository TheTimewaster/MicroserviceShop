package app.catalog.controller;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	private static final String	PATH_TO_DATA	= "F:/User/Eigene Dokumente/eclipse workspace/MicroserviceShop/src/main/webapp/resources/catalog.json";

	protected Logger			logger			= Logger
	        .getLogger(CatalogController.class.getName());

	@Autowired
	public CatalogController()
	{

	}

	@RequestMapping("/catalog/all")
	public String getCatalog()
	{
		JSONObject obj = null;

		try
		{
			JSONParser parser = new JSONParser();
			obj = (JSONObject) parser.parse(new FileReader(new File(PATH_TO_DATA)));

		} catch (ParseException | IOException e)
		{
			e.printStackTrace();
		} 
		finally
		{
			
		}

		return obj.toJSONString();
	}
}
