package com.internettechnologie.pokedex.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POKEMON", referencedColumnName = "ID")
    private PokeName pokeName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POKEMON", referencedColumnName = "ID")
    private List<PokeVariant> pokeVariant;

    @Column(name = "DEX", nullable = false)
    private Integer dex;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "FAMILY", length=50)
    private String family;

    @Column(name = "REGION", length=50)
    private String region;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDex() {
        return dex;
    }

    public void setDex(Integer dex) {
        this.dex = dex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public PokeName getPokeName() {
        return pokeName;
    }

    public void setPokeName(PokeName pokeName) {
        this.pokeName = pokeName;
    }

    public List<PokeVariant> getPokeVariant() {
        return pokeVariant;
    }

    public void setPokeVariant(List<PokeVariant> pokeVariant) {
        this.pokeVariant = pokeVariant;
    }
}
