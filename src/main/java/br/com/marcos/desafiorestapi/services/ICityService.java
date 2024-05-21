package br.com.marcos.desafiorestapi.services;

import br.com.marcos.desafiorestapi.dtos.CreateCityRequest;
import br.com.marcos.desafiorestapi.dtos.CityResponse;

import java.util.List;

public interface ICityService {

    CityResponse createCity(CreateCityRequest city);
    List<CityResponse> findCityByName(String name);
    List<CityResponse> findCityByState(String state);

}
