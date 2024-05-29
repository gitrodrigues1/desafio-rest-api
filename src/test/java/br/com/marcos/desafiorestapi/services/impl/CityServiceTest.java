package br.com.marcos.desafiorestapi.services.impl;

import br.com.marcos.desafiorestapi.domain.City;
import br.com.marcos.desafiorestapi.domain.State;
import br.com.marcos.desafiorestapi.dtos.CreateCityRequest;
import br.com.marcos.desafiorestapi.dtos.CityResponse;
import br.com.marcos.desafiorestapi.exceptions.BusinessException;
import br.com.marcos.desafiorestapi.repositories.CityRepository;
import br.com.marcos.desafiorestapi.repositories.StateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static br.com.marcos.desafiorestapi.common.StubObjects.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class CityServiceTest {

    @InjectMocks
    private CityService cityService;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private StateRepository stateRepository;

    private City city;
    private State state;
    private CreateCityRequest createCityRequest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        state = new State("CE", "Ceará");
        city = new City(1L, "Fortaleza", new State("CE", "Ceará"));
        createCityRequest = new CreateCityRequest("Fortaleza", "CE");
    }
    @Test
    void createCity_WithValidData_shouldReturnCity() {
        var request = new CreateCityRequest("Fortaleza", "CE");

        when(stateRepository.findById(Mockito.anyString())).thenReturn(Optional.of(state));
        when(cityRepository.existsByNameAndStateId(createCityRequest.name(), createCityRequest.stateId())).thenReturn(false);
        when(cityRepository.save(any())).thenReturn(city);

        var response = cityService.createCity(request);

        assertThat(response).isEqualTo(new CityResponse(CITY));

    }

    @Test
    void createCity_WithInvalidData_shouldThrowException() {

        when(stateRepository.findById(Mockito.anyString()))
                .thenReturn(Optional.of(state));
        when(cityRepository.existsByNameAndStateId(createCityRequest.name(), createCityRequest.stateId()))
                .thenReturn(true);

        assertThatThrownBy(() -> {
                    cityService.createCity(createCityRequest);
                })
                .isInstanceOf(BusinessException.CityAlreadyExistsException.class)
                .hasMessage("City already exists.");
    }

    @Test
    void findCity_WithValidName_ShouldReturnCitiesList() {
        when(cityRepository.findCityByNameContainsIgnoreCase(city.getName()))
                .thenReturn(Optional.of(java.util.List.of(city)));

        var response = cityService.findCityByName(city.getName());

        assertThat(response).isEqualTo(List.of(new CityResponse(CITY)));
    }

    @Test
    void findCity_WithNonExistingName_ShouldReturnEmptyList() {
        when(cityRepository.findCityByNameContainsIgnoreCase(city.getName()))
                .thenReturn(Optional.of(Collections.emptyList()));

        var response = cityService.findCityByName(UNKNOWN_CITY_NAME);

        assertThat(response).isEqualTo(Collections.emptyList());
    }

    @Test
    void findCity_WithExistingState_ShouldReturnCitiesList() {
        when(cityRepository.findCityByState(CITIES.get(0).getState().getId()))
                .thenReturn(Optional.of(CITIES));

        var response = cityService.findCityByState(CITIES.get(0).getState().getId());

        assertThat(response.get(0).stateId()).isEqualTo("PE");
    }



}