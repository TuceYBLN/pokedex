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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POKEMON_ID")
    private Pokemon pokemon;

    @Column(name = "DEX", nullable = false)
    private Integer dex;

    @Column(name = "VARIANT", length = 100)
    private String variant;

    @Column(name = "SHINY")
    private Boolean shiny;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POKE_OWNER", referencedColumnName = "ID")
    private PokeOwner pokeOwner;

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

    public Integer getDex() {
        return dex;
    }

    public void setDex(Integer dex) {
        this.dex = dex;
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

    public PokeOwner getPokeOwner() {
        return pokeOwner;
    }

    public void setPokeOwner(PokeOwner pokeOwner) {
        this.pokeOwner = pokeOwner;
    }
}
