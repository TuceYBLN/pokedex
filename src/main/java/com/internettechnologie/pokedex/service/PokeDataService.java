package com.internettechnologie.pokedex.service;

import com.internettechnologie.pokedex.dto.PokeDataDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PokeDataService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PokeDataDto> getCombinedData() {
        String sql = "SELECT " +
                "pokemon.dex, " +
                "poke_name.name_de, " +
                "poke_name.name_en, " +
                "poke_name.name_fr, " +
                "poke_name.name_ja, " +
                "poke_name.name_kr, " +
                "poke_name.name_zh, " +
                "pokemon.family, " +
                "types," +
                "pokemon.region FROM pokemon JOIN poke_name ON pokemon.pokename_id = poke_name.pokemon_id JOIN pokemon_types ON pokemon_types.pokemon_id = pokemon.id;";

        Query query = entityManager.createNativeQuery(sql);

        return query.getResultList();
    }
}