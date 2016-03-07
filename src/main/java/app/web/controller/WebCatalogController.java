package app.web.controller;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.web.services.WebCatalogService;


@RestController
public class WebCatalogController
{

	@Autowired
	WebCatalogService	_catalogService;

	protected Logger	logger	= Logger
	        .getLogger(WebCatalogController.class.getName());

	public WebCatalogController(WebCatalogService catalogService)
	{
		this._catalogService = catalogService;
	}

	@RequestMapping("/catalog/all")
	public String getCatalog(Model model)
	{
		String ret = _catalogService.getCatalog();
		return ret;
	}
}
