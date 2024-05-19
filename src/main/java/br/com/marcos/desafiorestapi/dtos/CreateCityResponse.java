package br.com.marcos.desafiorestapi.dtos;


import br.com.marcos.desafiorestapi.domain.City;

import java.util.List;

public record CreateCityResponse(
        Long id,
        String name,
        String stateId
) {
    public CreateCityResponse(City entity) {
        this(entity.getId(), entity.getName(), entity.getState().getId());
    }

    public static List<CreateCityResponse> toRecord(List<City> entities) {
        return entities.stream().map(CreateCityResponse::new).toList();
    }
}
