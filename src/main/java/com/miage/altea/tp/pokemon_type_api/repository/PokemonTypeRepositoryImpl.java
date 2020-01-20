package com.miage.altea.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {
    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        return pokemons.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        return pokemons.stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return pokemons;
    }

    @Override
    public List<PokemonType> findPokemonByType(List<String> types) {
        return pokemons.stream().filter(p -> !Collections.disjoint(p.getTypes(), types)).collect(Collectors.toList());
    }
}
