package com.internettechnologie.pokedex.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "OWNER")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "VARIANT_ID")
    private PokeVariant pokeVariant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PokeVariant getPokeVariant() {
        return pokeVariant;
    }

    public void setPokeVariant(PokeVariant pokeVariant) {
        this.pokeVariant = pokeVariant;
    }
}
