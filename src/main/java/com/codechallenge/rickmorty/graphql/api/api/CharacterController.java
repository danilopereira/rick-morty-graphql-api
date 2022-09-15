package com.codechallenge.rickmorty.graphql.api.api;

import com.codechallenge.rickmorty.graphql.api.model.Character;
import com.codechallenge.rickmorty.graphql.api.service.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
@Slf4j
public class CharacterController {

    private CharacterService characterService;

    public CharacterController(@Autowired CharacterService characterService) {
        this.characterService = characterService;
    }

    @QueryMapping
    public Set<Character> findByName(@Argument String name) {
        log.debug(String.format("find by name endpoint reached with the follow argument: name = %s", name));
        return characterService.findByName(name);
    }
}
