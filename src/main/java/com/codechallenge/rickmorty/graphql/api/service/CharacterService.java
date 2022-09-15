package com.codechallenge.rickmorty.graphql.api.service;

import com.codechallenge.rickmorty.graphql.api.model.Character;
import com.codechallenge.rickmorty.graphql.api.repository.CharacterRepository;
import com.codechallenge.rickmorty.graphql.api.repository.CharacterRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CharacterService {
    private static final String WHITE_SPACE_REGEX = "\\s";
    private CharacterRepository characterRepository;

    public CharacterService(@Autowired CharacterRepositoryImpl characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Set<Character> findByName(String name) {
        return characterRepository.getAllCharacters().stream()
                .filter(character -> characterNameMatchesQueryName(character.getName(), name))
                .sorted(Comparator.comparingInt(Character::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private boolean characterNameMatchesQueryName(String characterName, String name) {
        final String[] splitNames = characterName.split(WHITE_SPACE_REGEX);
        if(name.equals(characterName)) {
            return true;
        }

        for (String characterSplitName : splitNames) {
            if (name.equals(characterSplitName)) {
                return true;
            }
        }
        return false;
    }
}
