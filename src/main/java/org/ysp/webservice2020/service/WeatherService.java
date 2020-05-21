package org.ysp.webservice2020.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.webservice2020.ysp.org")
public interface WeatherService {
    @WebMethod
    String queryWeather(@WebParam(name = "city") String city);
}
