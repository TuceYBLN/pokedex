package com.internettechnologie.pokedex.dto;

public class PokemonOwnerDto {

    private Long id;

    private Long pokeVariantId;

    public PokemonOwnerDto(Long id, Long pokeVariantId) {
        this.id = id;
        this.pokeVariantId = pokeVariantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPokeVariantId() {
        return pokeVariantId;
    }

    public void setPokeVariantId(Long pokeVariantId) {
        this.pokeVariantId = pokeVariantId;
    }
}
