package com.internettechnologie.pokedex.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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
    @JoinColumn(name = "POKENAME_ID", referencedColumnName = "ID")
    private PokeName pokeName;

    @OneToMany(mappedBy = "pokemon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PokeVariant> pokeVariant = new ArrayList<>();

    @Column(name = "DEX", nullable = false)
    private Integer dex;

    //Quell: https://www.baeldung.com/java-jpa-persist-string-list
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @Column(name = "TYPES")
    private List<String>  types = new ArrayList<>();;

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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
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
