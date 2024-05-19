package br.com.marcos.desafiorestapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCityRequest(
        @NotBlank(message = "Name must not be blank.")
        String name,

        @Size(min = 2, max = 2, message = "State must have 2 letters.")
        String stateId
) {

}
