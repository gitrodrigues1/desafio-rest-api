package br.com.marcos.desafiorestapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    private State state;

    public City(Long id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }

}
