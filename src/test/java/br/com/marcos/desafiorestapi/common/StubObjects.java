package br.com.marcos.desafiorestapi.common;

import br.com.marcos.desafiorestapi.domain.City;
import br.com.marcos.desafiorestapi.domain.State;
import br.com.marcos.desafiorestapi.dtos.CreateCityRequest;

public class StubObjects {

    public static final CreateCityRequest REQUEST = new CreateCityRequest("São Paulo", "SP");
    public static final City CITY = new City("São Paulo", new State("SP", "São Paulo"));
    public static final State STATE = new State("SP", "São Paulo");
}
