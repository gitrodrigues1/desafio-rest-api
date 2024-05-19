package br.com.marcos.desafiorestapi.repositories;

import br.com.marcos.desafiorestapi.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    Optional<List<City>> findCityByNameContainsIgnoreCase(String name);

    @Query( value = "SELECT * FROM city a WHERE a.state_id = ?1", nativeQuery = true)
    Optional<List<City>> findCityByState(String state);

    boolean existsByNameAndStateId(String name, String stateId);
}