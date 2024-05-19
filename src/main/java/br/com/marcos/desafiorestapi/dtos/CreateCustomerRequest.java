package br.com.marcos.desafiorestapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public record CreateCustomerRequest(
        @NotBlank String name,
        String gender,
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        String birthDate,
        @NotNull
        int age,
        @NotNull Long cityId
) {

    public boolean isValidAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(birthDate, formatter);
        int calculatedAge = Period.between(date, LocalDate.now()).getYears();
        return calculatedAge == age;
    }

}
