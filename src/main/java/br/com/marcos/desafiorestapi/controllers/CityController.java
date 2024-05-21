package br.com.marcos.desafiorestapi.controllers;

import br.com.marcos.desafiorestapi.dtos.CreateCityRequest;
import br.com.marcos.desafiorestapi.dtos.CityResponse;
import br.com.marcos.desafiorestapi.services.ICityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@Tag(name = "City Controller", description = "API para cadastro de cidades.")
public class CityController {

    private final ICityService cityService;

    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @Operation(summary = "Cadastrar nova cidade.", description = "Cadastra uma nova cidade.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cidade cadastrada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Cidade já cadastrada.")
    })
    @PostMapping
    public ResponseEntity<CityResponse> createCity(
            @Valid @RequestBody CreateCityRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cityService.createCity(request));
    }

    @Operation(summary = "Pesquisar cidade pelo nome", description = "Retorna uma lista de cidades pelo nome ou uma lista vazia caso não encontrado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cidade encontrada com sucesso."),
    })
    @GetMapping("/name/{name}")
    public ResponseEntity<List<CityResponse>> findCityByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cityService.findCityByName(name));
    }

    @Operation(summary = "Pesquisar cidades por estado", description = "Retorna uma lista de cidades ou uma lista vazia caso não encontrado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cidades encontradas com sucesso."),
    })
    @GetMapping("/state/{state}")
    public ResponseEntity<List<CityResponse>> findCityByState(@PathVariable String state) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cityService.findCityByState(state));
    }
}
