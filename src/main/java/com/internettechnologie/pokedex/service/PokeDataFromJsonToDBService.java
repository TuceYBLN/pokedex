package com.internettechnologie.pokedex.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internettechnologie.pokedex.dto.PokemonDto;
import com.internettechnologie.pokedex.dto.PokemonVariantDto;
import com.internettechnologie.pokedex.entity.PokeName;
import com.internettechnologie.pokedex.entity.PokeVariant;
import com.internettechnologie.pokedex.entity.Pokemon;
import com.internettechnologie.pokedex.repository.PokeNameRepository;
import com.internettechnologie.pokedex.repository.PokeVariantRepository;
import com.internettechnologie.pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokeDataFromJsonToDBService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokeNameRepository pokeNameRepository;

    @Autowired
    private PokeVariantRepository pokeVariantRepository;

    public void moveJsonDatatoDB(ObjectMapper mapper, TypeReference<List<PokemonDto>> typeReference, InputStream inputStreamPokemon, TypeReference<List<PokemonVariantDto>> typeReferenceForVariant, InputStream inputStreamPokemonVariante) throws IOException {
        List<PokemonDto> pokemonDto = mapper.readValue(inputStreamPokemon, typeReference);
        List<PokemonVariantDto> pokemonVariantDto = mapper.readValue(inputStreamPokemonVariante, typeReferenceForVariant);

        pokemonDatenSetzen(pokemonDto);
        variantDatenSetzen(pokemonVariantDto);
    }

    private void pokemonDatenSetzen(List<PokemonDto> pokemonDto) {
        List<PokeName> allPokemonNames = new ArrayList<>();
        for (PokemonDto dto : pokemonDto) {
            PokeName name = new PokeName();
            name.setNameDE(dto.getName().get("de"));
            name.setNameEN(dto.getName().get("en"));
            name.setNameFR(dto.getName().get("fr"));
            name.setNameJA(dto.getName().get("ja"));
            name.setNameKR(dto.getName().get("kr"));
            name.setNameZH(dto.getName().get("zh"));

            Pokemon pokemon = new Pokemon();
            pokemon.setDex(dto.getDex());
            pokemon.setTypes(dto.getTypes());
            pokemon.setFamily(dto.getFamily());
            if (dto.getDex() >= 1 && dto.getDex() <= 151) {
                pokemon.setRegion("Kanto");
            } else if (dto.getDex() >= 152 && dto.getDex() <= 251) {
                pokemon.setRegion("Johto");
            } else {
                pokemon.setRegion("Hoenn");
            }
            name.setPokemon(pokemon);

            pokemonRepository.save(pokemon);
            allPokemonNames.add(name);
        }
        pokeNameRepository.saveAll(allPokemonNames);
    }

    private void variantDatenSetzen(List<PokemonVariantDto> pokemonVariantDto) {
        List<PokeVariant> allPokeVariants = new ArrayList<>();

        List<String> pokeVariant = pokemonVariantDto.get(0).getPokemonVariante();
        for (String variantDataFromDto : pokeVariant) {
            var splittedPokeInfo = variantDataFromDto.split("_");
            int pokeDexFromVariant = Integer.parseInt(splittedPokeInfo[2]);

            PokeVariant variant = new PokeVariant();
            variant.setDex(pokeDexFromVariant);

            Pokemon pokemon = pokemonRepository.findByDex(pokeDexFromVariant);

            if (pokemon != null) {
                variant.setPokemon(pokemon);
                if (splittedPokeInfo[splittedPokeInfo.length - 1].equals("shiny")) {
                    variant.setShiny(true);
                } else {
                    variant.setShiny(false);
                }

                if ((splittedPokeInfo.length == 4)) {
                    variant.setVariant(splittedPokeInfo[3]);
                } else if ((splittedPokeInfo.length == 5 && !splittedPokeInfo[4].equals("shiny")) || splittedPokeInfo.length == 6) {
                    variant.setVariant(splittedPokeInfo[3] + "_" + splittedPokeInfo[4]);
                } else {
                    variant.setVariant(splittedPokeInfo[3]);
                }
                allPokeVariants.add(variant);
            }
        }
        pokeVariantRepository.saveAll(allPokeVariants);
    }
}
