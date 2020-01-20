package com.miage.altea.tp.pokemon_type_api.controller;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    public PokemonTypeService pokemonTypeService;

    @Autowired
    public PokemonTypeController(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id){
        return pokemonTypeService.getPokemonType(id);
    }

    @GetMapping(value = "/", params = "name")
    PokemonType getPokemonTypeFromName(@RequestParam("name") String name){
        return pokemonTypeService.getPokemonType(name);
    }

    @GetMapping(value = "/", params = "types")
    List<PokemonType> getPokemonTypeFromName(@RequestParam("types") List<String> types){
        return pokemonTypeService.getPokemonByTypes(types);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }
}
