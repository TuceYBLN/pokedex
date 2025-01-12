package com.internettechnologie.pokedex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "POKE_OWNER")
public class PokeOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
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
