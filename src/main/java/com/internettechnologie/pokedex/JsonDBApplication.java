package com.internettechnologie.pokedex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internettechnologie.pokedex.dto.PokemonDto;
import com.internettechnologie.pokedex.dto.PokemonVariantDto;
import com.internettechnologie.pokedex.service.PokeDataFromJsonToDBService;
import com.internettechnologie.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.util.List;

/**
 * Da bereits ausgefuehrt, um Daten in die DB zu bekommen, wird diese Klasse ausgeblendet beim Ausfuehren von der Applikation.
 */
//@SpringBootApplication
public class JsonDBApplication {

    @Autowired
    private PokeDataFromJsonToDBService pokeDataFromJsonToDBService;

    public static void main(String[] args) {
        SpringApplication.run(JsonDBApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ConfigurableApplicationContext context, PokemonService pokemonService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<PokemonDto>> typeReference = new TypeReference<>() {};
            InputStream inputStreamPokemon = TypeReference.class.getResourceAsStream("/data/Pokemon.json");

            TypeReference<List<PokemonVariantDto>> typeReferenceForVariant = new TypeReference<>() {};
            InputStream inputStreamPokemonVariante = TypeReference.class.getResourceAsStream("/data/Pokemon_Variante.json");
             mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            try {
                pokeDataFromJsonToDBService.moveJsonDatatoDB(mapper, typeReference, inputStreamPokemon, typeReferenceForVariant, inputStreamPokemonVariante);
                //Spring Boot Application sollte sich beenden, wenn alles erfolgreich ausgefuehrt wurde. Status-Code 0 signalisiert Erfolgsmeldung.
                SpringApplication.exit(context, () -> 0);
            } catch (IOException e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }


}
