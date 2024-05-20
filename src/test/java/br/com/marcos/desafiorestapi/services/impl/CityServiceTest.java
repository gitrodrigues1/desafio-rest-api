package br.com.marcos.desafiorestapi.services.impl;

import br.com.marcos.desafiorestapi.common.StubObjects;
import br.com.marcos.desafiorestapi.domain.City;
import br.com.marcos.desafiorestapi.domain.State;
import br.com.marcos.desafiorestapi.dtos.CreateCityRequest;
import br.com.marcos.desafiorestapi.dtos.CreateCityResponse;
import br.com.marcos.desafiorestapi.repositories.CityRepository;
import br.com.marcos.desafiorestapi.repositories.StateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.times;

@SpringBootTest(classes = CityService.class)
class CityServiceTest {

    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private StateRepository stateRepository;

    City city;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        city = StubObjects.CITY;
    }

    @Test
    void createCity_WithValidData_shouldReturnCity() {
        var request = new CreateCityRequest("Fortaleza", "CE");
        var response = new CreateCityResponse(1L, "Fortaleza", "CE");

        Mockito.when(cityService.createCity(request)).thenReturn(response);
        Mockito.when(cityRepository.save(city)).thenReturn(city);
        Mockito.when(stateRepository.findById(request.stateId())).thenReturn(Optional.of(new State("CE", "Ceará")));

        Mockito.verify(cityService, times(1)).createCity(request);

    }

}