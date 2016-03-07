package app.web.services;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebCatalogService
{
	@Autowired
	protected RestTemplate	_restTemplate;

	protected String		_serviceUrl;

	protected Logger		logger	= Logger
	        .getLogger(WebCatalogService.class.getName());

	public WebCatalogService(String serviceUrl)
	{
		// assigning root service url
		this._serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
		        : "http://" + serviceUrl;
	}

	public String getCatalog()
	{
		logger.info("show whole catalog");
		return _restTemplate.getForObject(_serviceUrl + "/catalog/all",
		        String.class);
	}

}
