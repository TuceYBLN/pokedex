package com.internettechnologie.pokedex.dto;

public class PokeVariantOwnedDto {

    private Long id;

    public PokeVariantOwnedDto() {
    }

    public PokeVariantOwnedDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
