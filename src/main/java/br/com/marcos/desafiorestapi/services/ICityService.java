package br.com.marcos.desafiorestapi.services;

import br.com.marcos.desafiorestapi.dtos.CreateCityRequest;
import br.com.marcos.desafiorestapi.dtos.CreateCityResponse;

import java.util.List;

public interface ICityService {

    CreateCityResponse createCity(CreateCityRequest city);
    List<CreateCityResponse> findCityByName(String name);
    List<CreateCityResponse> findCityByState(String state);

}
