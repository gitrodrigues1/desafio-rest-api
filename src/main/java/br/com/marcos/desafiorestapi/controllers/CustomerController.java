package br.com.marcos.desafiorestapi.controllers;

import br.com.marcos.desafiorestapi.dtos.CreateCustomerRequest;
import br.com.marcos.desafiorestapi.dtos.CustomerResponse;
import br.com.marcos.desafiorestapi.dtos.UpdateCustomerRequest;
import br.com.marcos.desafiorestapi.services.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer Controller", description = "API para cadastro de consumidores.")
@CrossOrigin
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Criar novo consumidor", description = "Cria um novo consumidor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consumidor cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Consumidor já cadastrado.")
    })
    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(
            @Valid @RequestBody CreateCustomerRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.createCustomer(request));
    }

    @Operation(summary = "Pesquisar consumidor por nome.", description = "Pesquisa um consumidor pelo nome.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consumidor encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Consumidor não encontrado.")
    })
    @GetMapping("/name/{name}")
    public CustomerResponse findCustomerByName(@PathVariable String name) {
        return customerService.findCustomerByName(name);
    }

    @Operation(summary = "Pesquisar consumidor por id", description = "Pesquisa um consumidor pelo id cadastrado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consumidor encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Consumidor não encontrado.")
    })
    @GetMapping("/{id}")
    public CustomerResponse findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @Operation(summary = "Atualizar consumidor", description = "Atualiza os dados do consumidor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consumidor atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Consumidor não encontrado.")
    })
    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerRequest request) {
        return customerService.updateCustomerName(id,request);
    }

    @Operation(summary = "Excluir consumidor", description = "Exclui um consumidor através do seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Consumidor excluído com sucesso."),
            @ApiResponse(responseCode = "404", description = "Consumidor não encontrado.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
