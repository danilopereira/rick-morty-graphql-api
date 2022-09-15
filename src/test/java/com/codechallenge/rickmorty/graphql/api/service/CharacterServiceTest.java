package com.codechallenge.rickmorty.graphql.api.service;

import com.codechallenge.rickmorty.graphql.api.model.Character;
import com.codechallenge.rickmorty.graphql.api.repository.CharacterRepositoryImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharacterServiceTest {
    @Mock
    private CharacterRepositoryImpl characterRepository;

    @InjectMocks
    private CharacterService characterService;

    @BeforeEach
    public void setup() {
        when(characterRepository.getAllCharacters()).thenReturn(mockCharacters());
    }

    @Test
    void testFindByNameShouldReturnOneResult() {
        Set<Character> characters = characterService.findByName("Rick Sanchez");
        assertEquals(1, characters.size());
    }

    @Test
    void testFindBySingleNameShouldMatchSpecificResult() {
        Set<Character> characters = characterService.findByName("Alexander");
        assertEquals(1, characters.size());
    }

    @Test
    void testFindByFirstNameShouldMatchMoreThanOneResult() {
        Set<Character> characters = characterService.findByName("Rick");
        assertTrue(characters.size() > 1);
    }

    @Test
    void testFindByFamilyNameShouldReturnMultipleResults() {
        Set<Character> characters = characterService.findByName("Smith");
        assertTrue(characters.size() > 1);
    }

    @Test
    void testFindByNameNotFound() {
        Set<Character> characters = characterService.findByName("TEST TEST");
        assertTrue(characters.isEmpty());
    }

    private Set<Character> mockCharacters(){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(getClass().getResourceAsStream("/results.json"), new TypeReference<>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }
}