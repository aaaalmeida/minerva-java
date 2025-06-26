package com.aaalmeida.minerva.infrastructure.http.controller;

import com.aaalmeida.minerva.application.useCase.Author.*;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.dto.FollowRequestDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {
    private ListAllAuthorUseCase listAllAuthorUseCase;
    private CreateAuthorUseCase createAuthorUseCase;
    private FindAuthorByIdUseCase findAuthorByIdUseCase;
    private FindAuthorByNameUseCase findAuthorByNameUseCase;
    private FindAuthorByLastNameUseCase findAuthorByLastNameUseCase;
    private DeleteAuthorUseCase deleteAuthorUseCase;
    private FollowAuthorUseCase followAuthorUseCase;
    private UnfollowAuthorUseCase unfollowAuthorUseCase;

    @GetMapping("/hello")
    public String hello() {
        return "v2";
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findAllAuthor() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listAllAuthorUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> findAuthorById(@PathVariable String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findAuthorByIdUseCase.execute(id));
    }

    @GetMapping("/name={name}")
    public ResponseEntity<List<AuthorDTO>> findAuthorByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findAuthorByNameUseCase.execute(name));
    }

    @GetMapping("/lastname={lastName}")
    public ResponseEntity<List<AuthorDTO>> findAuthorByLastName(@PathVariable String lastName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(findAuthorByLastNameUseCase.execute(lastName));
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody @Valid AuthorDTO author) {
        AuthorDTO response = createAuthorUseCase.execute(author);
        URI location = URI.create("/author/" + response.uuid());
        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(response);
    }

    @PostMapping("/follow")
    public ResponseEntity<AuthorDTO> followAuthor(@RequestBody @Valid FollowRequestDTO followRequestDTO) {
        URI location = URI.create("author/" + followRequestDTO.baseId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(location)
                .body(followAuthorUseCase.execute(followRequestDTO));
    }

    @DeleteMapping("/follow")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unfollowAuthor(@RequestBody @Valid FollowRequestDTO followRequestDTO) {
        unfollowAuthorUseCase.execute(followRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable String id) {
        deleteAuthorUseCase.execute(id);
    }
}
