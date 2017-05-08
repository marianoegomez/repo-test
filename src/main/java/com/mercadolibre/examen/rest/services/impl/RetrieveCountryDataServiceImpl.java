package com.mercadolibre.examen.rest.services.impl;

import com.mercadolibre.examen.rest.services.BaseRestService;
import com.mercadolibre.examen.rest.services.request.Request;
import com.mercadolibre.examen.rest.services.request.RetrieveCountryDataRequest;
import com.mercadolibre.examen.rest.services.response.Response;
import com.mercadolibre.examen.rest.services.response.RetrieveCountryDataResponse;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Clase que implementa la invocacion especifica del servicio restcountries
 * 
 * @author Mariano
 */
public class RetrieveCountryDataServiceImpl extends BaseRestService  {

	private static final String URL = "https://restcountries.eu/rest/v2/alpha/";
	
	public Response send(Request request) {
		try {

			ClientResponse response = createRequest(this.getURL(((RetrieveCountryDataRequest)request).getCountryCode()));
			Response rcdr = (RetrieveCountryDataResponse)response.getEntity(RetrieveCountryDataResponse.class);

			return rcdr;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	private final String getURL(String countryCode) {
		return RetrieveCountryDataServiceImpl.URL + countryCode;
	}

}
