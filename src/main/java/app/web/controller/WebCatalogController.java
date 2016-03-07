package app.web.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.web.services.WebCatalogService;


@Controller
public class WebCatalogController
{
	private static final String	PATH_TO_DATA	= "F:/User/Eigene Dokumente/eclipse workspace/MicroserviceShop/src/main/webapp/resources/catalog.json";

	@Autowired
	WebCatalogService			_catalogService;

	protected Logger			logger			= Logger
	        .getLogger(WebCatalogController.class.getName());

	public WebCatalogController(WebCatalogService catalogService)
	{
		this._catalogService = catalogService;
	}

	@RequestMapping("/catalog/all")
	public String getCatalog(Model model)
	{
		StringWriter writer = null;
		BufferedReader reader = null;
		
		String var = _catalogService.getCatalog();

		try
		{
			reader = new BufferedReader(new FileReader(new File(PATH_TO_DATA)));
			String line = "";
			writer = new StringWriter();

			while ((line = reader.readLine()) != null)
			{
				writer.append(line);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				reader.close();
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model.addAttribute("catalog", writer.toString());
		return "catalog";
	}
}
