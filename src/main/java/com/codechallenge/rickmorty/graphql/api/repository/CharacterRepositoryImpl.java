package com.codechallenge.rickmorty.graphql.api.repository;

import com.codechallenge.rickmorty.graphql.api.model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Set;

@Repository
@Slf4j
public class CharacterRepositoryImpl implements CharacterRepository {
    private ObjectMapper objectMapper;

    private Set<Character> characters = Collections.emptySet();

    public CharacterRepositoryImpl(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @PostConstruct
    void initialize() {
        characters = loadCharacters();
    }

    @Override
    public Set<Character> getAllCharacters() {
        return characters;
    }

    private Set<Character> loadCharacters() {
        try{
            return objectMapper.readValue(getClass().getResourceAsStream("/results.json"), new TypeReference<>() {});
        } catch (Exception e) {
            log.error(String.format("Error while parser the json result -> %s", e.getMessage()));
        }
        return Collections.emptySet();
    }
}
