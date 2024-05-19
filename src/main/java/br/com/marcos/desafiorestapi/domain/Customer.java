package br.com.marcos.desafiorestapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private int age;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Customer() {
    }

    public Customer(Long id, String name, String gender, LocalDate birthDate, int age, City city) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.city = city;
    }

    public Customer(String name, String gender, LocalDate birthDate, int age, City city) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.age = age;
        this.city = city;
    }


}
