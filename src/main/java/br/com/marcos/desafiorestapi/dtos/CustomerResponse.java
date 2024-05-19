package br.com.marcos.desafiorestapi.dtos;


import br.com.marcos.desafiorestapi.domain.Customer;

import java.time.format.DateTimeFormatter;

public record CustomerResponse(
        Long id,
        String name,
        String gender,
        String birthDate,
        int age,
        String city,
        String state
) {
    public CustomerResponse(Customer entity) {
        this(entity.getId(),
                entity.getName(),
                entity.getGender(),
                entity.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                entity.getAge(),
                entity.getCity().getName(),
                entity.getCity().getState().getName()
        );
    }

}
