package com.internettechnologie.pokedex.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "POKE_VARIANT")
public class PokeVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POKEMON_ID", nullable = false)
    private Pokemon pokemon;

    @Column(name = "VARIANT", length = 100)
    private String variant;

    @Column(name = "SHINY")
    private Boolean shiny;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POKE_VARIANT", referencedColumnName = "ID")
    private Owner owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public Boolean getShiny() {
        return shiny;
    }

    public void setShiny(Boolean shiny) {
        this.shiny = shiny;
    }
}
