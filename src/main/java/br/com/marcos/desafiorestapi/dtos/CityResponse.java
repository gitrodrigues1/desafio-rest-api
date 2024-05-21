package br.com.marcos.desafiorestapi.dtos;


import br.com.marcos.desafiorestapi.domain.City;

import java.util.List;

public record CityResponse(
        Long id,
        String name,
        String stateId
) {
    public CityResponse(City entity) {
        this(entity.getId(), entity.getName(), entity.getState().getId());
    }

    public static List<CityResponse> toRecord(List<City> entities) {
        return entities.stream().map(CityResponse::new).toList();
    }
}
