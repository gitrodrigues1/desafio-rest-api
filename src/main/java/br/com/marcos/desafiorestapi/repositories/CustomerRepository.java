package br.com.marcos.desafiorestapi.repositories;

import br.com.marcos.desafiorestapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByName(String name);
}
