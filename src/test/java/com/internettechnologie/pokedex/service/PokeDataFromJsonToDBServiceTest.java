package com.internettechnologie.pokedex.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internettechnologie.pokedex.dto.PokemonDto;
import com.internettechnologie.pokedex.dto.PokemonVariantDto;
import com.internettechnologie.pokedex.entity.PokeName;
import com.internettechnologie.pokedex.entity.PokeVariant;
import com.internettechnologie.pokedex.entity.Pokemon;
import com.internettechnologie.pokedex.repository.PokeNameRepository;
import com.internettechnologie.pokedex.repository.PokeVariantRepository;
import com.internettechnologie.pokedex.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PokeDataFromJsonToDBServiceTest {

    private Pokemon pokemon;

    private PokeName pokeName;

    @Mock
    private PokemonRepository pokemonRepository;

    @Mock
    private PokeNameRepository pokeNameRepository;

    @Mock
    private PokeVariantRepository pokeVariantRepository;

    private ObjectMapper objectMapper;

    @InjectMocks
    private PokeDataFromJsonToDBService pokeDataFromJsonToDBService;

    private TypeReference<List<PokemonDto>> typeReferencePokemon;

    private TypeReference<List<PokemonVariantDto>> typeReferenceVariant;

    private InputStream inputStreamPokemon;

    private InputStream inputStreamPokemonVariante;


    @BeforeEach
    void setUp() {

        pokemonEntitieserstellen();

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        typeReferencePokemon = new TypeReference<>() {
        };
        typeReferenceVariant = new TypeReference<>() {
        };
        inputStreamPokemon = getClass().getClassLoader().getResourceAsStream("PokemonTest.json");
        inputStreamPokemonVariante = getClass().getClassLoader().getResourceAsStream("Pokemon_VarianteTest.json");

        when(pokemonRepository.save(any(Pokemon.class))).thenAnswer(i -> i.getArguments()[0]);
        when(pokeDataFromJsonToDBService.pokemonRepository.findByDex(2)).thenReturn(pokemon);
    }

    private void pokemonEntitieserstellen() {
        List<String> pokeTypes = new ArrayList<>();
        pokeTypes.add("grass");
        pokeTypes.add("poison");

        pokeName = new PokeName();
        pokeName.setId(1L);
        pokeName.setNameDE("Bisaknosp");
        pokeName.setNameDE("Ivysaur");
        pokeName.setNameFR("Herbizarre");
        pokeName.setNameJA("フシギソウ");
        pokeName.setNameKR("이상해풀");
        pokeName.setNameZH("妙蛙草");

        pokemon = new Pokemon();
        pokemon.setId(1L);
        pokemon.setDex(2);
        pokemon.setFamily("Bulbasaur");
        pokemon.setRegion("Kanto");
        pokemon.setTypes(pokeTypes);
        pokemon.setPokeName(pokeName);

        List<PokeVariant> pokeVariant = new ArrayList<>();
        PokeVariant variantOne = new PokeVariant();
        variantOne.setId(1L);
        variantOne.setDex(2);
        variantOne.setPokemon(pokemon);
        variantOne.setPokeOwner(null);
        variantOne.setShiny(false);
        variantOne.setVariant("00");
        pokeVariant.add(variantOne);

        PokeVariant variantTwo = new PokeVariant();
        variantTwo.setId(2L);
        variantTwo.setDex(2);
        variantTwo.setPokemon(pokemon);
        variantTwo.setPokeOwner(null);
        variantTwo.setShiny(true);
        variantOne.setVariant("00");
        pokeVariant.add(variantTwo);

        pokemon.setPokeVariant(pokeVariant);
    }


    @Test
    void datenUndRegionWerdenGespeichert() throws IOException {
        pokeDataFromJsonToDBService.moveJsonDatatoDB(objectMapper, typeReferencePokemon, inputStreamPokemon, typeReferenceVariant, inputStreamPokemonVariante);

        Pokemon savedPokemon = pokemonRepository.findByDex(2);

        assertEquals(2, savedPokemon.getDex());
        assertEquals("Kanto", savedPokemon.getRegion());
    }

    @Test
    void kannVariantenRichtigSetzenEinfachMitUnterscheidungShiny() throws IOException {
        pokeDataFromJsonToDBService.moveJsonDatatoDB(objectMapper, typeReferencePokemon, inputStreamPokemon, typeReferenceVariant, inputStreamPokemonVariante);

        Pokemon savedPokemon = pokemonRepository.findByDex(2);
        assertFalse(savedPokemon.getPokeVariant().get(0).getShiny());
        assertTrue(savedPokemon.getPokeVariant().get(1).getShiny());
    }
}