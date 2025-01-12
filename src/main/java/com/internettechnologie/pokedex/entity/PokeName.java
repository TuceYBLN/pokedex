package com.internettechnologie.pokedex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "POKE_NAME")
public class PokeName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "POKEMON_ID", referencedColumnName = "ID")
    private Pokemon pokemon;

    @Column(name = "NAME_DE", length = 100)
    private String nameDE;

    @Column(name = "NAME_EN", length = 100)
    private String nameEN;

    @Column(name = "NAME_FR", length = 100)
    private String nameFR;

    @Column(name = "NAME_JA", length = 100)
    private String nameJA;

    @Column(name = "NAME_KR", length = 100)
    private String nameKR;

    @Column(name = "NAME_ZH", length = 100)
    private String nameZH;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDE() {
        return nameDE;
    }

    public void setNameDE(String nameDE) {
        this.nameDE = nameDE;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameFR() {
        return nameFR;
    }

    public void setNameFR(String nameFR) {
        this.nameFR = nameFR;
    }

    public String getNameJA() {
        return nameJA;
    }

    public void setNameJA(String nameJA) {
        this.nameJA = nameJA;
    }

    public String getNameKR() {
        return nameKR;
    }

    public void setNameKR(String nameKR) {
        this.nameKR = nameKR;
    }

    public String getNameZH() {
        return nameZH;
    }

    public void setNameZH(String nameZH) {
        this.nameZH = nameZH;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        if (pokemon != null) {
            pokemon.setPokeName(this);
        }
    }
}
