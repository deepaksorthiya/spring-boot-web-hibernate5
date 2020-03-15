package com.example.users.rest;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.model.User;
import com.example.users.repo.UserRepository;
import com.example.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    private final EntityManager entityManager;

    public UserController(UserService userService, UserRepository userRepository, EntityManager entityManager) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody @Valid User user, @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable long userId, @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userService.findById(userId).get(), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<User>> findAll(@NotNull final Pageable pageable,
                                              @RequestHeader HttpHeaders httpHeaders) {
        System.out.println(entityManager);
        Map<String, Object> properties = entityManager.getProperties();
        System.out.println(properties);
        return new ResponseEntity<>(userRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAllWithRoles(@NotNull final Pageable pageable,
                                                       @RequestHeader HttpHeaders httpHeaders) {
        return new ResponseEntity<>(userRepository.findAllFetchRolesEagerlyXX(pageable), HttpStatus.OK);
    }
}
