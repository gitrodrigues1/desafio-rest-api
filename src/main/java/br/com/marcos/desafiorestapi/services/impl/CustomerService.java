package br.com.marcos.desafiorestapi.services.impl;

import br.com.marcos.desafiorestapi.domain.City;
import br.com.marcos.desafiorestapi.domain.Customer;
import br.com.marcos.desafiorestapi.domain.GenderEnum;
import br.com.marcos.desafiorestapi.dtos.CreateCustomerRequest;
import br.com.marcos.desafiorestapi.dtos.CustomerResponse;
import br.com.marcos.desafiorestapi.dtos.UpdateCustomerRequest;
import br.com.marcos.desafiorestapi.exceptions.BusinessException;
import br.com.marcos.desafiorestapi.repositories.CityRepository;
import br.com.marcos.desafiorestapi.repositories.CustomerRepository;
import br.com.marcos.desafiorestapi.services.ICustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CityRepository cityRepository;

    public CustomerService(CustomerRepository customerRepository, CityRepository cityRepository) {
        this.customerRepository = customerRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest request) {

        City city = cityRepository.findById(request.cityId())
                .orElseThrow(BusinessException.InvalidCityIdException::new);

        if(!request.isValidAge()){
            throw new BusinessException.InvalidYearOrAgeException();
        }

        if(customerRepository.findCustomerByName(request.name()).isPresent())
            throw new BusinessException.CustomerAlreadyExistsException();

        Customer newCustomer = new Customer(
                request.name(),
                GenderEnum.valueOf(request.gender()),
                LocalDate.parse(request.birthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                request.age(),
                city);

        return new CustomerResponse(customerRepository.save(newCustomer));
    }

    @Override
    public CustomerResponse findCustomerByName(String name) {
        Customer foundCustomer = customerRepository.findCustomerByName(name)
                .orElseThrow(BusinessException.CustomerNotFoundException::new);
        return new CustomerResponse(foundCustomer);
    }

    @Override
    public CustomerResponse findCustomerById(Long id) {
        Customer foundCustomer = customerRepository.findById(id)
                .orElseThrow(BusinessException.CustomerNotFoundException::new);
        return new CustomerResponse(foundCustomer);
    }

    @Override
    public CustomerResponse updateCustomerName(Long id, UpdateCustomerRequest request) {
        Customer foundCustomer = customerRepository.findById(id)
                .orElseThrow(BusinessException.CustomerNotFoundException::new);
        foundCustomer.setName(request.name());
        return new CustomerResponse(customerRepository.save(foundCustomer));
    }

    @Override
    public void deleteCustomerById(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new BusinessException.CustomerNotFoundException();
        }
        customerRepository.deleteById(id);
    }
}
