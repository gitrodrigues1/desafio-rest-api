package br.com.marcos.desafiorestapi.common;

import br.com.marcos.desafiorestapi.domain.City;
import br.com.marcos.desafiorestapi.domain.State;
import br.com.marcos.desafiorestapi.dtos.CreateCityRequest;

import java.util.List;

public class StubObjects {

    public static final CreateCityRequest REQUEST = new CreateCityRequest("São Paulo", "SP");
    public static final City CITY = new City(1L, "Fortaleza", new State("CE", "Fortaleza"));
    public static final String UNKNOWN_CITY_NAME = "Jaboatão dos Guararapes";
    public static final State STATE = new State("SP", "São Paulo");

    public static final List<City> CITIES = List.of(
            new City(1L, "Olinda", new State("PE", "Pernambuco")),
            new City(2L, "Recife", new State("PE", "Pernambuco"))
    );
}
