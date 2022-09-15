package com.codechallenge.rickmorty.graphql.api.repository;

import com.codechallenge.rickmorty.graphql.api.model.Character;

import java.util.Set;

public interface CharacterRepository {
    Set<Character> getAllCharacters();
}
