package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;

import java.util.List;

public interface PokemonTypeService {
    PokemonType getPokemonType(int id);
    PokemonType getPokemonType(String name);
    List<PokemonType> getAllPokemonTypes();
    List<PokemonType> getPokemonByTypes(List<String> types);
}
