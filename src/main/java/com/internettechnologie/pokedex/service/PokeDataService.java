package com.internettechnologie.pokedex.service;

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
        String sql = "SELECT\n" +
                "poke_variant.id,\n" +
                "pokemon.dex, \n" +
                "poke_name.name_de, \n" +
                "poke_name.name_en, \n" +
                "poke_name.name_fr,\n" +
                "poke_name.name_ja, \n" +
                "poke_name.name_kr,\n" +
                "poke_name.name_zh, \n" +
                "pokemon.family,\n" +
                "types,\n" +
                "is_shiny,\n" +
                "variant,\n" +
                "image,\n" +
                "pokemon.region, is_owned FROM pokemon JOIN poke_name ON pokemon.pokename_id = poke_name.pokemon_id JOIN pokemon_types ON pokemon_types.pokemon_id = pokemon.id JOIN poke_variant ON pokemon.id = poke_variant.pokemon_id;\n";

        // SQL Anfrage setzen und Ergebnisse in einer HashMap nach VariantID
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        Map<Long, PokeDataDto> groupedByVariantId = new HashMap<>();


        for (Object[] row : results) {
            Long id = (Long) row[0];
            Integer dex = (Integer) row[1];
            String name_de = (String) row[2];
            String name_en = (String) row[3];
            String name_fr = (String) row[4];
            String name_ja = (String) row[5];
            String name_kr = (String) row[6];
            String name_zh = (String) row[7];
            String family = (String) row[8];
            String types = (String) row[9];
            Boolean isShiny = (Boolean) row[10];
            String variant = (String) row[11];
            String image = (String) row[12];
            String region = (String) row[13];
            Boolean isOwned = (Boolean) row[14];

            PokeDataDto dto = groupedByVariantId.get(id);

            // ID nicht auffindbar im aktuellen Stand des Dtos dann setzen
            if (dto == null) {
                dto = new PokeDataDto(id, dex, name_de, name_en, name_fr, name_ja, name_kr, name_zh, family, new ArrayList<>(), isShiny, variant, image, region, isOwned);
                groupedByVariantId.put(id, dto);
            }
            dto.getTypes().add(types);
        }

        return new ArrayList<>(groupedByVariantId.values());
    }
}
