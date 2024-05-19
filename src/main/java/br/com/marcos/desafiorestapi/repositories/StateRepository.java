package br.com.marcos.desafiorestapi.repositories;


import br.com.marcos.desafiorestapi.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, String> {
}
