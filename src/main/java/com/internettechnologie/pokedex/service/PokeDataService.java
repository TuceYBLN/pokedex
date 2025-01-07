package com.internettechnologie.pokedex.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.internettechnologie.pokedex.dto.PokeDataDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<Object[]> results = query.getResultList();

        Map<Integer, PokeDataDto> groupedByDex = new HashMap<>();


        for (Object[] row : results) {
            Integer dex = (Integer) row[0];
            String name_de = (String) row[1];
            String name_en = (String) row[2];
            String name_fr = (String) row[3];
            String name_ja = (String) row[4];
            String name_kr = (String) row[5];
            String name_zh = (String) row[6];
            String family = (String) row[7];
            String types = (String) row[8];
            String region = (String) row[9];

            PokeDataDto dto = groupedByDex.get(dex);

            if(dto == null){
                dto = new PokeDataDto(dex, name_de, name_en, name_fr, name_ja, name_kr, name_zh, family, new ArrayList<>(), region);
                groupedByDex.put(dex, dto);
            }
            dto.getTypes().add(types);
        }

        return new ArrayList<>(groupedByDex.values());
    }
}
