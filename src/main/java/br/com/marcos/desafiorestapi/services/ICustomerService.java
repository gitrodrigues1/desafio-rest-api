package br.com.marcos.desafiorestapi.services;


import br.com.marcos.desafiorestapi.dtos.CreateCustomerRequest;
import br.com.marcos.desafiorestapi.dtos.CustomerResponse;
import br.com.marcos.desafiorestapi.dtos.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerResponse createCustomer(CreateCustomerRequest request);
    CustomerResponse findCustomerByName(String name);
    CustomerResponse findCustomerById(Long id);

    CustomerResponse updateCustomerName(Long id, UpdateCustomerRequest request);
    void deleteCustomerById(Long id);

}
