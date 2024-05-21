package br.com.marcos.desafiorestapi.services.impl;

import br.com.marcos.desafiorestapi.domain.City;
import br.com.marcos.desafiorestapi.domain.State;
import br.com.marcos.desafiorestapi.dtos.CreateCityRequest;
import br.com.marcos.desafiorestapi.dtos.CityResponse;
import br.com.marcos.desafiorestapi.exceptions.BusinessException;
import br.com.marcos.desafiorestapi.repositories.CityRepository;
import br.com.marcos.desafiorestapi.repositories.StateRepository;
import br.com.marcos.desafiorestapi.services.ICityService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CityService implements ICityService {

    private final CityRepository cityRepository;
    private final StateRepository stateRepository;

    public CityService(CityRepository cityRepository, StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public CityResponse createCity(CreateCityRequest city) {

        State state = stateRepository.findById(city.stateId())
                .orElseThrow(BusinessException.InvalidStateException::new);

        City newCity = new City(city.name(), state);

        if (cityRepository.existsByNameAndStateId(city.name(), city.stateId())) {
            throw new BusinessException.CityAlreadyExistsException();
        }
        return new CityResponse(cityRepository.save(newCity));
    }

    @Override
    public List<CityResponse> findCityByName(String name) {
        return cityRepository.findCityByNameContainsIgnoreCase(name)
                .orElse(Collections.emptyList())
                .stream().map(CityResponse::new).toList();
    }

    @Override
    public List<CityResponse> findCityByState(String state) {
        return cityRepository.findCityByState(state)
                .orElse(Collections.emptyList())
                .stream().map(CityResponse::new).toList();
    }
}
