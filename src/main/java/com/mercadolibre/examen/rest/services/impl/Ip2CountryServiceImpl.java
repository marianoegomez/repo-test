package com.mercadolibre.examen.rest.services.impl;

import com.mercadolibre.examen.rest.services.BaseRestService;
import com.mercadolibre.examen.rest.services.request.Ip2CountryRequest;
import com.mercadolibre.examen.rest.services.request.Request;
import com.mercadolibre.examen.rest.services.response.Ip2CountryResponse;
import com.mercadolibre.examen.rest.services.response.Response;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Clase que implementa la invocacion especifica del servicio ip2country
 * 
 * @author Mariano
 */
public class Ip2CountryServiceImpl extends BaseRestService {
	
	private static final String URL = "https://api.ip2country.info/ip?";

	public Response send(Request request) {

		try {
			ClientResponse response = createRequest(this.getURL(((Ip2CountryRequest)request).getIp()));
			Response ip2cr = response.getEntity(Ip2CountryResponse.class);

			return ip2cr;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	private final String getURL(String ip) {
		return Ip2CountryServiceImpl.URL + ip;
	}

}
